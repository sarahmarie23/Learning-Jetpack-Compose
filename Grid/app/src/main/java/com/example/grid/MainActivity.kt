package com.example.grid

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.grid.model.Topic
import com.example.grid.ui.theme.GridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                }
            }
        }
    }
}
/*
@Composable
fun GridApp() {
    GridTheme {
        GridList(topics = )
    }
}
*/
@SuppressLint("ResourceType")
@Composable
fun TopicItemCard(topic : Topic, modifier: Modifier = Modifier) {
    Card(modifier = Modifier
        .requiredHeight(68.dp)) {
        Row() {
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.titleResourceID),
                modifier = Modifier.size(68.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = stringResource(topic.titleResourceID),
                    style = typography.body2
                )
                Row(
                    verticalAlignment = CenterVertically,
                    modifier = Modifier.padding(vertical = 8.dp),
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color.Black),
                        modifier = Modifier.padding(end = 8.dp),

                    )
                    Text(
                        text = topic.courseResourceId.toString(),
                        style = typography.caption
                    )

                }
            }
        }
    }
}
/*
@Composable
private fun TopicsList(topicList: List<Topic>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(topicList) {topic -> TopicItemCard(topic)

        }
    }
}
*/
@Preview(showBackground = true)
@Composable
fun TopicItemCardPreview() {
    TopicItemCard(Topic(R.string.architecture, 58, R.drawable.architecture))
}