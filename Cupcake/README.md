# Cupcake app  
An app for customers to make a cupcake order. They can then send the order information to another app for processing.

# App preview  
<p float="left">
  <img src = "https://github.com/sarahmarie23/Learning-Jetpack-Compose/blob/main/Cupcake/Cupcake.gif" width = "200"> 
</p>


# Compose topics covered

### Terms learned  

* **Jetpack Navigation** - used to build multiscreen apps in Compose. Place individual screens in the 'iu' directory
(which also holds components directory, theme directory, and ViewModels). Place the starting screen along with the MainActivity in the 
com.exanmple.appname directory. The three components of navigation are
	* NavController
	* NavGraph
	* NavHost

* **NavController** - Used to navigate between screens.

* **NavGraph** - Maps composable destinations to navigate to.

* **Backstack** - Keeps track of the screens visited and pops them off if the user clicks up

* **Intents** - A request for the system to perform some action.

* **ShareSheet** - A user interface component that covers the bottom part of the screen. It's part of the OS so instead of calling it
with navController, you call it with an Intent.

* **AppBar** - A toolbar that is used in `Scaffold` as a header or footer

### Code learned  

* **NavHostController** (class) - A subclass of NavController, used for Compose. Place this as a parameterin the main app 
composable function 

`navController: NavHostController = rememberNavController()`

* **NavHost** (Composable) - used to define routes and screens. Acts as a container for displaying the current destination
of the NavGraph. It includes parameters for navController and startDestination.

```kotlin  
    NavHost(
        navController = navController,
        startDestination = CupcakeScreen.Start.name,
        modifier = Modifier.padding(innerPadding)
    ) {
	//composable functions go here	
    }
```

* **composable** (function) - This function takes in a route (using the enum values makes this easy to keep track of) and the 
trailing lambda holds the content that you want to display for that route, which would be the corresponding screen

```kotlin
    composable(route = CupcakeScreen.Start.name) {
        StartOrderScreen(
            //parameters
        )
    }
```

* **Context** (abstract class) - Allows access to app-specific resources and classes. For this app, it is used to get the list
of flavors to display. Place this in the composable's lambda.

`val context =  LocalContext.current`

To retrieve the list, set the 'options' parameter (which is a list of strings) like this. Note that the flavors list was one list 
contained in the object DataSource.

`options = DataSource.flavors.map { id -> context.resources.getString(id) }`

* **navigate** (method) - Used to navigate to a screen listed in the NavHost. It takes in a route.

`navController.navigate(CupcakeScreen.Flavor.name)`

* **popBackStack** (method) - Given a route and `inclusive` Boolean, will go back to that route when called.

`navController.popBackStack(CupcakeScreen.Start.name, inclusive = false)`

* **Intent** (object) - Add information here that will be shared.

```kotlin
val intent = Intent(Intent.ACTION_SEND).apply {
    type = "text/plain"
    putExtra(Intent.EXTRA_SUBJECT, subject)
    putExtra(Intent.EXTRA_TEXT, summary)
}
```

### Notes  

* Define the routes in an enum class. Place this in the main page screen, after the import statements.
  
```kotlin
enum class CupcakeScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Flavor(title = R.string.choose_flavor),
    Pickup(title = R.string.choose_pickup_date),
    Summary(title = R.string.order_summary)
}
```

* The system back button is located on the bottom of the screen, whereas the Up botton is located in the AppBar. Both
will navigate to the previous screen.
