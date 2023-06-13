package com.example.thirtytips

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.thirtytips.R

data class Tip(
    @StringRes val name: Int,
    val category: Category,
    @StringRes val shortText: Int,
    @StringRes val longText: Int,
    @DrawableRes val image: Int,

)

val tips = listOf(
    Tip(R.string.tip_1_name, Category.BODY, R.string.tip_1_short_text, R.string.tip_1_long_text, R.drawable.deep_breathing),
    Tip(R.string.tip_2_name, Category.BODY, R.string.tip_2_short_text, R.string.tip_2_long_text,R.drawable.progressive_muscle_relaxation),
    Tip(R.string.tip_3_name, Category.BODY, R.string.tip_3_short_text, R.string.tip_3_long_text, R.drawable.body_posture),
    Tip(R.string.tip_4_name, Category.BODY, R.string.tip_4_short_text, R.string.tip_4_long_text,R.drawable.cardiovascular_exercise),
    Tip(R.string.tip_5_name, Category.BODY, R.string.tip_5_short_text, R.string.tip_5_long_text, R.drawable.good_sleep),
    Tip(R.string.tip_6_name, Category.BODY, R.string.tip_6_short_text, R.string.tip_6_long_text, R.drawable.avoiding_sugar),
    Tip(R.string.tip_7_name, Category.BODY, R.string.tip_7_long_text, R.string.tip_7_short_text, R.drawable.probiotics),
    Tip(R.string.tip_8_name, Category.BODY, R.string.tip_8_short_text, R.string.tip_8_long_text, R.drawable.mindfulness_yoga),
    Tip(R.string.tip_9_name, Category.BODY, R.string.tip_9_short_text, R.string.tip_9_long_text, R.drawable.water_on_face),
    Tip(R.string.tip_10_name, Category.BODY, R.string.tip_10_short_text, R.string.tip_10_long_text, R.drawable.meditation),

    //Tip("Replace thoughts", Category.MIND, R.drawable.)
)