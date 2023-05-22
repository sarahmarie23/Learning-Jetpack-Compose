# Thirty Tips app  
The purpose of this app is to display anxiety management strategies that focus on a certain area (mind, body, behavior, etc).
It uses colorful imagery and simple text.
This concept serves as a base idea for a much more involved mental health management app. 

# App preview  

<p float="left">
  <img src = "https://github.com/sarahmarie23/Learning-Jetpack-Compose/blob/main/ThirtyTips/ThirtyTips.gif" width = "200"> 
</p>


# Compose topics covered

### Code learned  

* **rememberScrollState** (function) - This was needed to make the text description scrollable on those with
longer descriptions

`val scroll = rememberScrollState()`


* **verticalScroll** (Modifier) - When text is too large to display all of it in a card, add a 
verticalScroll. horizontalScroll does the same thing but for horizontal containers.

```kotlin  
   Text(modifier = Modifier
      .padding(horizontal = 8.dp, vertical = 4.dp)
      .verticalScroll(scroll))
``` 


### Notes  

* Adobe Stock is a great source of professional photography and graphics. I was able to download photos using the Education License which 
is included with the Adobe Creative Cloud student package. I only advocate using graphics which you have the proper permissions to use!
  

