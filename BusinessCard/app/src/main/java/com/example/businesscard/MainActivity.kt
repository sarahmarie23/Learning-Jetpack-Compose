package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Row(
            modifier = modifier.padding(top = 130.dp)
        ) {
            Person(stringResource(id = R.string.sarah_martel),
                stringResource(id = R.string.title))
        }
        Row(
            //modifier = modifier
              //  .padding(bottom = 50.dp)

        ) {
            ContactInfo(
                stringResource(id = R.string.phone_number),
                stringResource(id = R.string.social_media),
                stringResource(id = R.string.emai)
            )
        }

        }


}

@Composable
fun Person( name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(top = 10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.sarah_portrait_square),
            contentDescription = "Portrait",
            modifier = Modifier
                .size(100.dp)
                .border(
                    BorderStroke(4.dp, Color.Blue),
                    CircleShape
                )
                .clip(CircleShape)

        )
        Text(text = name, fontSize = 24.sp, modifier = modifier.padding(top = 8.dp))
        Text(text = title, fontSize = 20.sp,  modifier = modifier.padding(top = 8.dp))
    }
}

@Composable
fun ContactInfo(phone: String, social_media: String, email: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.Start,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = modifier.padding(top = 10.dp)
        ) {
            Icon(Icons.Rounded.Phone, contentDescription = "Phone", modifier = Modifier.padding(start = 10.dp, end = 10.dp))
            Text(text = phone, fontSize = 18.sp)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = modifier.padding(top = 10.dp)
        ) {
            Icon(Icons.Rounded.Info, contentDescription = "Icon", modifier = Modifier.padding(start = 10.dp, end = 10.dp))
            Text(text = social_media, fontSize = 18.sp)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = modifier.padding(top = 10.dp)
        ) {
            Icon(Icons.Rounded.Email, contentDescription = "Email", modifier = Modifier.padding(start = 10.dp, end = 10.dp))
            Text(text = email, fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCard()
    /*
    BusinessCardTheme {
        Person(stringResource(id = R.string.sarah_martel),
        stringResource(id = R.string.title))
    }

     ContactInfo(
         stringResource(id = R.string.phone_number),
         stringResource(id = R.string.social_media),
         stringResource(id = R.string.emai)
     )
     */

}