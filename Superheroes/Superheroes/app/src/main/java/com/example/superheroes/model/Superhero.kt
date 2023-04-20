package com.example.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.superheroes.R

data class Superhero(
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)
