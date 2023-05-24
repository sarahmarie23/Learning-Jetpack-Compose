# Unscramble app  
A game to see how many words you can unscramble correctly. 

# App preview  

<p float="left">
  <img src = "https://github.com/sarahmarie23/Learning-Jetpack-Compose/blob/main/Unscramble/Unscramble.gif" width = "200"> 
</p>


# Compose topics covered

### Terms learned  


* **ViewModel** - Architecture component and class from the Android Jetpack library. It allows you to persist UI state and provides access to business logic.
Prevents the need to fetch data again when navigating between activities or after configuration changes.
The data is lost when the activity is destroyed because of process death.
Implement it by extending the ViewModel class

* **App architecture** - The standard for designing apps. Ensures that an app can be robust, flexible, scalable, testable, and maintainable.
Official documentation can be found <a href ="https://developer.android.com/topic/architecture>here</a>.

* **Separation of concerns** - Design principle where the app's functions are divided into classes, each with separate responsibilities.

* **Drive UI from a model** - Drive your UI from a persistent model. This model is separate from the UI elements and app components.

* **UI layer** - Presentation layer. Displays app data but is independent of the data.
It is made out of UI elements (ex: composables) and State holders (ex: ViewModel)

* **Data layer** - Stores, retrieves, and exposes the app data.

* **Domain layer** - Optional layer to reuse interactions between the UI and data layers.

* **Unidirectional data flow (UDF)** - The design pattern in which **state flows down and events flow up**. ViewModel passes down the UI state to the 
UI elements, and displays it. The UI elements pass events upwards to the ViewModel, which might change the state. The cycle continues.

* **Backing property** - Used to avoid state updates from other classes. Denote it with _, such as `private var _count = 0`. It lets you
return something from a getter other than the exact object. This allows you to have a getter that returns a read-only version of the data.
You can also use it to make the data private and mutable.

* **Alert dialog** - A small window that prompts the user to make a decision or enter additional information. For this app, it was used to 
indicate that the game has ended and ask if the user would like to play again.

### Code learned  

* **StateFlow** (interface) - Holds data and sends current and new state updates. Used with `MutableStateFlow`. Initialize the
StateFlow in the ViewModel class file.


```kotlin  
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
```

* **lateinit** (property) - Memory isn't allocated at initialization. This is used because you will initialize it later.

`private lateinit var currentWord: String`

* **init** (block) - It is always called after the primary constructor. It allows you to add code to the primary constructor because you can't
have code directly in the primary constructor.

* **update** (function) - Upddates the MutableStateFlow.value

```kotlin
       _uiState.update { currentState ->
           currentState.copy(isGuessedWordWrong = true)
```


```kotlin
init {
   resetGame()
}
```

### Notes  

* Keep the app's data and logic away from composables.
* Use a data class to hold values for a UI state definition, which is immutable. This ensures it can't be altered by multilple sources at 
a moment in time. 
* Never modifiy the UI state in the UI directly, unless the UI itself is the sole source of its data. This is what ViewModel is for.
* This is only a taste of app architecture; more will be learned along the way.
