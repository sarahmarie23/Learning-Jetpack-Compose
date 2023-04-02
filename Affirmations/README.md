# Affirmations app  
This app shows inspirational phrases and aesthetically-pleasing photos. 
The user can scroll up and down to view the photos.

# App preview  
<p float="left">
  <img src = "https://github.com/sarahmarie23/Learning-Jetpack-Compose/blob/a48bac11ecf869d6076fd5c624f71c5ca3db23ef/Affirmations/Affirmations.gif" width = "200"> 
</p>


# Compose topics covered

### Terms learned  

* **Data class** - A clas that only contains properties. You can add them to a package under com.example.appname. 
For example:
```kotlin
data class Affirmation(
   @StringRes val stringResourceId: Int,
   @DrawableRes val imageResourceId: Int
)
```

* **Launcher icon** - Located in the resources directory. Mipmap folders hold vector images for different density screens. As of Android 8.0, there is support for a foreground and background layer instead of just one layer.

* **Safe zone** - Different devices display apps in various shapes, so to ensure the graphic will fit with all devices, make sure it lies within the safe zone.

### Code learned  

* **Card** (Composable) - A surface that's used with a row or column 

* **LazyColumn** (Composable) - Column that can add content on demand, good for long lists with unknown lengths. It also provides scrolling by default.
For example:
```kotlin
LazyColumn {
  items(affirmationList){ affirmation ->
    AffirmationCard(affirmation)
  }
}
```

### Notes  

* Regular classes can have constructors, functions, properties, nested classes, and object declarations whereas data classes can only have properties.
* It is a best practice to pass a modifier to every composable and set it to a default value.
`modifier: Modifier = Modifier`

