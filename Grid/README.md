# Grid app  
This app shows how a list can be displayed into two columns.
I also adjusted the little bulletpoint graphic and background in response to a screen going into dark mode.

# App preview  
<p float="left">
  <img src = "https://github.com/sarahmarie23/Learning-Jetpack-Compose/blob/7be07edaf91abe90a9bc098bbb26b536ac383fbe/Grid/Grid.gif" width = "200"> 
</p>


# Compose topics covered

### Terms and code learned  

* **LazyVerticalGrid** (Composable) - Like a LazyColumn, but you can specify multiple columns instead of just one. Items are filled in row by row working down. There is also a LazyVerticalGrid.
* **isSystemInDarkTheme** (function) - call this function so you can make changes based on if the device is in light or dark mode.
```kotlin
colorFilter = if (!isSystemInDarkTheme()) ColorFilter.tint(Color.Black) else null
```

### Notes  

* I adjusted the background color with a value that was in the GridApp funtion. There is probably a better/more preferred way to do this with themes or styles.
* When I was setting the colorFilter based on if the screen was in dark mode, I needed to include an else condition. There is probably a better looking way to do this.

