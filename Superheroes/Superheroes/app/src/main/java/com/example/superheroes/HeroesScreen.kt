package com.example.superheroes

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.HeroesRepository.heroes
import com.example.superheroes.model.Superhero
import com.example.superheroes.ui.theme.Shapes
import com.example.superheroes.ui.theme.SuperheroesTheme

@Composable
fun SuperheroListItem(superhero: Superhero, modifier: Modifier = Modifier) {
    Card(
        shape = Shapes.medium,
        elevation = 2.dp,
        modifier = Modifier.padding(
            start = 16.dp,
            top = 8.dp,
            end = 16.dp,
            bottom = 8.dp
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(maxHeight = 72.dp)
        ) {
            Column(
                //modifier = Modifier.height(72.dp)
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
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .clip(Shapes.small),
                painter = painterResource(superhero.image),
                contentDescription = null
            )
        }
    }
}
/*
@Composable
fun SuperheroApp() {
    Scaffold(
        content = {
            it
            LazyColumn(
                modifier = Modifier.background(MaterialTheme.colors.background)
            ) {

                items(heroes) {
                    SuperheroListItem(superhero = it)
                }
            }
        }
    )
}
*/
@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeroPreview() {
    val hero = Superhero(
        R.string.hero1,
        R.string.description1,
        R.drawable.android_superhero1
    )
    SuperheroesTheme {
        SuperheroListItem(superhero = hero)
    }
}
/*
@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SuperheroAppPreview() {
    val hero = Superhero(
        R.string.hero1,
        R.string.description1,
        R.drawable.android_superhero1
    )
    SuperheroesTheme {
        SuperheroApp()
    }
}
*/