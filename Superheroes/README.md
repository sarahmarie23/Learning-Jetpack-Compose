# Superheroes app

Shows a list of superheroes with an image and text for each superhero.  
Works in both light and dark mode.

# App preview

<p float="left">
  <img src = "/Superheroes/Superheros.gif" width = "200"> 
</p>
Superheroes/Superheros.gif

# Compose topics covered

### Terms learned


* **Updating Gradle dependencies** - It was tempting to click on the 'Project update recommended' window   
that was trying to get me to upgrade Android Gradle plugin version to 7.4.2 by using the AGP Upgrade Assistant.  
I followed through with their steps figuring that it would put in the correct versions but I could never get it  
to fully work with all their recommendations. I decided to update what I could, even if it wasn't what they recommended  
I realized that it would be most important for the `compileSdk` to be 33 and `minSdk` to be 24.  

### Code learned

* **sizeIn** (Modifier extension function) - I ran into issues getting the text to display properly. It was fine for short descriptions but lines which were longer didn't display the second line. This made it so that there would be an even height. It was placed in the parent `Row` modifier.  

  `modifier = Modifier.sizeIn(maxHeight = 72.dp)`

* **Scaffold** (Composable) - A helpful way to provide slots for components and screen elements. The Scaffold in this project held the top bar and `LazyColumn`, which displayed each superhero using `it`, which is an implicit name of a single parameter. `it` is used in lambda expressions as a single parameter. This makes it much more concise when iterating through a list.  

### Notes

* Be careful when updating dependencies.
* Utilize applications that can help choose colors. https://m3.material.io/theme-builder#/custom makes it easy to visualize how the colors would look on an app.

