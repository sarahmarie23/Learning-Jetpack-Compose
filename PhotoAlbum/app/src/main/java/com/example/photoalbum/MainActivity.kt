package com.example.photoalbum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.photoalbum.R.color.black
import com.example.photoalbum.ui.theme.PhotoAlbumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoAlbumTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PhotoAlbumScreen()
                }
            }
        }
    }
}

@Composable
fun PhotoAlbumScreen() {
    //add variables
    var current by remember { mutableStateOf(1) }
    val img = when(current) {
        1 -> R.drawable.donuts
        2 -> R.drawable.gum
        3 -> R.drawable.totem
        else -> R.drawable.donuts
    }
    val desc = when(current) {
        1 -> R.string.photo_1_desc
        2 -> R.string.photo_2_desc
        3 -> R.string.photo_3_desc
        else -> R.string.photo_1_desc
    }
    val title = when(current) {
        1 -> R.string.photo_1_title
        2 -> R.string.photo_2_title
        3 -> R.string.photo_3_title
        else -> R.string.photo_1_title
    }
    val loc = when(current) {
        1 -> R.string.loc_1
        2 -> R.string.loc_2
        3 -> R.string.loc_3
        else -> R.string.loc_1
    }
    val date = when(current) {
        1 -> R.string.day_2_date
        2 -> R.string.day_3_date
        3 -> R.string.day_5_date
        else -> R.string.photo_1_title
    }
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Image(
                painterResource(id = img),
                contentDescription = stringResource(id = desc),
                contentScale = ContentScale.Fit,
                modifier = Modifier.wrapContentSize()
                    .border(
                        BorderStroke(5.dp, Color(black)),
                    )
                    .weight(1f)
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = stringResource(id = title),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = stringResource(id = loc),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = stringResource(id = date),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                //.padding(horizontal = 30.dp)
        ) {
            Button(onClick = { if(current > 1) current-- },
                modifier = Modifier.width(150.dp)
            ) {
                Text(stringResource(id = R.string.previous))
            }
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Button(onClick = { if(current < 3) current++   },
                modifier = Modifier.width(150.dp)
            ) {
                Text(stringResource(id = R.string.next))
            }
        }
        
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PhotoAlbumTheme {
        PhotoAlbumScreen()
    }
}