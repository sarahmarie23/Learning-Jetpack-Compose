package com.example.cupcake.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.cupcake.test.data.TestData
import com.example.cupcake.ui.StartOrderScreen
import com.example.cupcake.ui.theme.CupcakeTheme
import org.junit.Rule
import org.junit.Test

class CupcakeStartScreenTest {

    val expectedOptions = TestData.quantity
    var selectedQuantity: Int? = null


    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun startScreen_verifyContent() {

        composeTestRule.setContent {
            CupcakeTheme {
                StartOrderScreen(
                    quantityOptions = expectedOptions,
                    onNextButtonClicked = { quantity -> selectedQuantity = quantity }
                )
            }
        }
        expectedOptions.forEach { option ->
            val stringLabel = composeTestRule.activity.getString(option.first)
            composeTestRule.onNodeWithText(stringLabel).assertIsDisplayed()
        }
        
    }
}