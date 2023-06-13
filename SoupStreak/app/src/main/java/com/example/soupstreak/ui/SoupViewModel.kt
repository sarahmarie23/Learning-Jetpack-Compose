import android.content.Context
import android.os.Bundle
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.soupstreak.ui.SoupScreen
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel


class SoupViewModel(private val context: Context, private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private val _count = mutableStateOf(0)
    private val _maxCount = mutableStateOf(0)

    val count: Int
        get() = _count.value

    val maxCount: Int
        get() = _maxCount.value

    init {
        loadMaxCountFromPreferences()
    }

    fun incrementCount() {
        _count.value++
        if (_count.value > _maxCount.value) {
            _maxCount.value = _count.value
            saveMaxCountToPreferences()
        }
    }

    fun resetCount() {
        _count.value = 0
    }

    fun resetMaxCount() {
        _maxCount.value = 0
        saveMaxCountToPreferences()
        resetCount()
    }

    private fun loadMaxCountFromPreferences() {
        val preferences = context.getSharedPreferences("SoupStreakPrefs", Context.MODE_PRIVATE)
        _maxCount.value = preferences.getInt("MaxCount", 0)
    }

    private fun saveMaxCountToPreferences() {
        val preferences = context.getSharedPreferences("SoupStreakPrefs", Context.MODE_PRIVATE)
        preferences.edit().putInt("MaxCount", _maxCount.value).apply()
    }
}

class SoupViewModelFactory(
    private val context: Context,
    owner: ViewModelStoreOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if (modelClass.isAssignableFrom(SoupViewModel::class.java)) {
            return SoupViewModel(context, handle) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

@Composable
fun MyApp() {
    val context = LocalContext.current
    val viewModel: SoupViewModel = viewModel(
        factory = SoupViewModelFactory(context, LocalViewModelStoreOwner.current)
    )
    SoupScreen(viewModel)
}