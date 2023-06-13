package com.example.test

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test.model.Superhero
//import com.example.superheroes.ui.theme.Shapes
import com.example.test.ui.theme.TestTheme

@Composable
fun SuperheroListItem(superhero: Superhero, modifier: Modifier = Modifier) {
    Card(
        elevation = 2.dp,
        modifier = modifier
        //.clip(Shapes.medium)

    ) {
        Row(){
            Column(
                modifier = modifier.padding(16.dp)
            ) {
                Text(
                    text = stringResource(superhero.name),
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = stringResource(superhero.description),
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(modifier = modifier.width(16.dp))
            Image(
                modifier = modifier,
                //.clip(Shapes.small),
                contentScale = ContentScale.Crop,
                painter = painterResource(superhero.image),
                contentDescription = null
            )

        }


    }
}
@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeroPreview() {
    val hero = Superhero(
        R.string.hero1,
        R.string.description1,
        R.drawable.android_superhero1
    )
    TestTheme {
        SuperheroListItem(superhero = hero)
    }
}