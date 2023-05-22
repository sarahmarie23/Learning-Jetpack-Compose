package com.example.thirtytips

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun TipCard(tip: Tip, modifier: Modifier = Modifier) {
    val isLongTextVisible = remember { mutableStateOf(false) }
    val scroll = rememberScrollState(0)

    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Center
    ) {
        if (isLongTextVisible.value) {
            Card(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(4.dp)
                    .height(160.dp)
                    .clickable { isLongTextVisible.value = false },
            ) {
                Text(
                    text = stringResource(tip.longText),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White,
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .verticalScroll(scroll)
                )
            }
        } else {
            Card(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(4.dp)
                    .height(160.dp)
                    .clickable { isLongTextVisible.value = true }
            ) {
                Image(
                    painter = painterResource(id = tip.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alpha = 0.7f,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Text(
                text = stringResource(tip.name),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { isLongTextVisible.value = true }
            )

        }

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayTips() {
    Scaffold(
        topBar = {},
        content = {
            it
            LazyColumn() {
                items(tips) {
                    TipCard(tip = it)
                }
            }
        }
    )


}

@Preview
@Composable
fun TipCardPreview() {
    TipCard(tips[0])

}

@Preview
@Composable
fun DisplayTipsPreview() {
    DisplayTips()

}