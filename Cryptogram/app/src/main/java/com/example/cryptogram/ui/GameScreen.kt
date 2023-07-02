package com.example.cryptogram.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptogram.ui.theme.CryptogramTheme

@Composable
fun GameScreen() {
    val quote = "Imagination is more important than knowledge."

    val encodedQuote = remember { Array<Char?>(quote.length) { if (quote[it].isLetter()) '*' else quote[it] } }
    val userInput = remember { mutableStateListOf<Char?>(*encodedQuote) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = encodedQuote.joinToString(" ") { it?.toString() ?: "" },
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        encodedQuote.forEachIndexed { index, char ->
            val isLetter = char?.isLetter() == true
            val inputText = if (isLetter) userInput[index]?.toString().orEmpty() else char?.toString().orEmpty()

            Text(
                text = inputText,
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(4.dp)
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(4.dp))
                    .widthIn(min = 40.dp)
                    .clickable(enabled = isLetter) {
                        userInput[index] = if (userInput[index] == '*') char else null
                    }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val isCorrect = userInput.joinToString("") { it?.toString() ?: "" } == quote
                // TODO: Show the result
            },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(text = "Submit")
        }

        Text(
            text = "Result will be shown here",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CryptogramTheme {
        GameScreen()
    }
}