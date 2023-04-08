# Woof app  
This app has an aesthetically-pleasing layout, in both light and dark mode.
It can be used by a dog adoption company for customers to scroll and find their new best friend.
The company header gives it a more professional look.

# App preview  
Light mode and dark mode views
<p float="left">
  <img src = "https://github.com/sarahmarie23/Learning-Jetpack-Compose/blob/2060903e79aa6b707d2d248c9cda885933c4a519/Woof/Woof.gif" width = "200"> 
</p>


# Compose topics covered

### Terms learned  


* **Material Design** - An open-source system of tools which helps create beautiful UI designs. It adheres to best practices of UI design, so you have a good guideline to work with.
It is open-source and besides Compose, it can be used with Flutter, Android, and Web frameworks. Definitely something to spend time getting comfortable with it.

* **Material Themeing** - Gives you guidance on the right colors, typography, and shapes for your app. 
Place your color values in `Color.kt`
Then in `Theme.kt` you can assign different colors for light and dark mode.

* **Typography** - Add fonts to the `Type.kt` file, which is part of the ui.theme package. Here you can customize the 13 font styles such as headlines, body, and caption.
Some example attributes to customize fonts include the font weight and font size.

* **Scaffold** (Composable) - Use this to make items such as a TopAppBar, BottomAppBar, or floating action button.  

### Code learned  

* **RoundedCornerShape** (Shape) - Used with modifier.clip() to make rounded shapes. A value of 50 (50%) would be a perfect circle, 0 is no rounded corners.

```kotlin  
Image(
    modifier = modifier
        .size(64.dp)
        .padding(8.dp)
        .clip(RoundedCornerShape(50)),
```

* **Shapes** (class) - Define shapes in the Shape.kt file so you can style your cards. For example:

```kotlin
val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(0.dp)
)
```

* **colors.xml** - Located under `app>res>values>colors.xml` it stores the colors that are used for th status bar. They are implemented in the `themes.xml` file.

### Notes  

* When using Compose you use Theme.kt and Color.kt for your themes and colors, but if you want to change colors for the status bar you need to do it in the xml file.
* Material Design has a ton of useful UI info and will be a huge help when trying to design my apps.
  

