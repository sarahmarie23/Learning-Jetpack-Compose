# Dessert Clicker app  
Keeps track of desserts being sold; to teach about configuration changes.

# App preview  

<p float="left">
  <img src = "https://github.com/sarahmarie23/Learning-Jetpack-Compose/blob/DessertClicker.gif" width = "200"> 
</p>


# Compose topics covered

### Terms learned  


* **Activity lifecycle** - An app goes through these stages: `onCreate()`, `onStart()`, `onResume ()` (these first three are called
when the app is started for the first time), `onPause()`, `onStop()`, and `onDestroy()`.
  - Override the state's callback method to add behavior during that state.
  - You can add in override methods manually or by selecting Code > Override Methods...

```kotlin
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }
```

* **Log / Logcat** - Displays messages that are useful for debugging.
  - Debug messages use `Log.d()`. Assign it a tag and a message.
  - Other types include `Log.v()` (verbose message), `Log.i()` (informational message), `Log.w()` (warnings), `Log.e()` (error messages).

* **Confirguration changes** - Occurs when the state of the device changes so radically that the easiest way for the system to
resolve the change is to destroy and rebuild the activity. 
  - When a user rotates the device, `onPause()`, `onStop()`, and `onDestroy()` are called, followed by `onCreate()`, `onStart()`, and `onResume()`. 
This means that values will be lost if they are not coded properly.

### Code learned  

* **rememberSaveable** (variable declaration) - use this instead of `remember` if you need to save a value that can survive a 
configuration change.
`var revenue by rememberSaveable { mutableStateOf(0) }`

### Notes  

* `onCreate()` and `onDestroy()` are only called once during the lifetime of a sigle activity instance. 
  
