# Tip calculator app  
Tip calculator that lets the user select the tip percent and gives them the option to round up the total.  
The previous version only calculated 15% tip. 

# App preview  
Improved version 
<p float="left">
  <img src = "https://github.com/sarahmarie23/Learning-Jetpack-Compose/blob/306c449dc0316ce4077fb49ff3ecdab9023813cf/TipTime/TipCalculator2.gif" width = "200">
&nbsp;&nbsp;&nbsp; 
  <img src = "https://github.com/sarahmarie23/Learning-Jetpack-Compose/blob/8ec80de5edd2019b9b3db5071a65d06106a3a175/TipTime/TipCalculator.gif" width = "200">
</p>


# Compose topics covered

### Terms learned  


* **State** - Something that can change over time, while the app is running. (ex. a variable, database, a button)
* **Composition** - Produced by an _initial composition_, it is a description of the UI when composables are executed.
* **Recomposition** - What Compose does to update composables that have changed state.
* **State hoisting** - Lift the state from a composable to make it stateless. Used if you need to share the state with multiple composable functions or make a stateless composable that can be reused.

### Code learned  

* **Spacer** (composable) - Adds a specified space between elements. You can also add in color, size, and weight.  
`Spacer(Modifier.height(16.dp))`

* **State and Mutable State** (types) 

* **onValueChange** (callback)  
`onValueChange = { amountInput = it }`

* **mutableStateOf** (function) - It holds a mutable state, and is observable by Compose so recomposition will be triggered

* **remember** (function) - Used to store values so they are saved during recomposition, used with mutableStateOf.  
`var amountInput by remember { mutableStateOf("") }`

* **Formatting currency** - Use this function:
`NumberFormat.getCurrencyInstance().format(tip)`

* **Keyboard with next and done button** - use a Keyboard Options constructor
```kotlin  
keyboardOptions = KeyboardOptions.Default.copy(
    keyboardType = KeyboardType.Number,
    imeAction = ImeAction.Next
       )
```
* **KeyboardActions** - Allows you to move the focus to the next field and done when finished
```kotlin  
keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down)})
keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
```

### Notes  

* You need to add in these import statements manually:  
```kotlin
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
``` 

* Set breakpoints and **Debug 'app'** so the app will pause at the breakpoints.  

* Refactor > Rename so all instances of the renamed object will be renamed automatically.  

* Best practice: include a default Modifier parameter as the first optional parameter for all composable functions
`modifier: Modifier = Modifier`

* Don't hardcode colors!
