package com.example.comeposequadrant

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.comeposequadrant.ui.theme.ComeposeQuadrantTheme
import kotlinx.coroutines.CompletionHandler


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComeposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Grid()
                }
            }
        }
    }
}

@Composable
fun Grid( modifier: Modifier = Modifier) {
    Column {
        Row(
            modifier = Modifier.fillMaxHeight(0.5f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.5f).background(Green),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center

            ) {
                val box1 = Box(
                    stringResource(id = R.string.text_composable),
                    stringResource(id = R.string.text_description)
                )
            }
            Column(
                modifier = Modifier.fillMaxSize().background(Yellow),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val box2 = Box(
                    stringResource(id = R.string.image_composable),
                    stringResource(id = R.string.image_description)
                )
            }
        }
        Row(

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.5f).background(Cyan),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val box3 = Box(
                    stringResource(id = R.string.row_composable),
                    stringResource(id = R.string.row_description)
                )
            }
            Column(
                modifier = Modifier.fillMaxSize().background(LightGray),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val box4 = Box(
                    stringResource(id = R.string.column_composable),
                    stringResource(id = R.string.column_description)
                )
            }
        }
    }

}

@Composable
fun Box(title: String, description: String, modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
            ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComeposeQuadrantTheme {
        Grid()

    }
}