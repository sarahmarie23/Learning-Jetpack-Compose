package com.example.superheroes.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.superheroes.R

// Set of Material typography styles to start with
val Cabin = FontFamily(
    Font(R.font.cabin_regular, FontWeight.Normal),
    Font(R.font.cabin_bold, FontWeight.Bold)
)


val Typography = Typography(
    defaultFontFamily = Cabin,
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)