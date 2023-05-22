package com.example.thirtytips

import androidx.annotation.StringRes

enum class Category(@StringRes val stringRes: Int) {
    BODY(R.string.category_1),
    MIND(R.string.category_2),
    EMOTION(R.string.category_3),
    BEHAVIOR(R.string.category_4),
    SOCIAL(R.string.category_5)
}