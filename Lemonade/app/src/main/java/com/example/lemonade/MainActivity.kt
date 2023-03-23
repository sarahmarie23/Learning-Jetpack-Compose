package com.example.lemonade

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    Make_Lemonade(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun Make_Lemonade(modifier: Modifier = Modifier) {
    var step by remember { mutableStateOf(1) }
    var squeezeCount = (3..20).random()
    val imageResource = when(step) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_restart
    }
    val textResource = when(step) {
        1 -> R.string.tap_tree
        2 -> R.string.squeeze_lemon
        3 -> R.string.drink_lemonade
        4 -> R.string.start_again
        else -> R.string.start_again
    }
    val contentDescriptionResource = when(step) {
        1 -> R.string.lemon_tree_content_description
        2 -> R.string.lemon_content_description
        3 -> R.string.glass_of_lemonade_content_description
        4 -> R.string.empty_glass_content_description
        else -> R.string.empty_glass_content_description
    }
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(id = textResource), fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
            when(step) {
                1, 3 -> step++
                2 -> if(squeezeCount > 0) squeezeCount-- else step++
                3 -> step++
                4 -> step = 1
                else -> step = 4
            }
        }
        ) {
            Image (
                painter = painterResource(id = imageResource),
                contentDescription = stringResource(id = contentDescriptionResource),
                Modifier.background(color = androidx.compose.ui.graphics.Color.White).background(
                    androidx.compose.ui.graphics.Color.White).border(BorderStroke(10.dp, color = androidx.compose.ui.graphics.Color.Yellow))
            )
        }

    }
}

