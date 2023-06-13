package com.example.grid.model

import android.media.Image
import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val titleResourceID : Int,
    val courseResourceId : Int,
    @DrawableRes val imageResourceId : Int,

)
