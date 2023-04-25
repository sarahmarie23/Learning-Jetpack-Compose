package com.example.thirtytips

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun DisplayCategoryList(modifier: Modifier = Modifier) {
    val categories = Category.values()

    Column{
        categories.forEach { category -> CategoryListItem(category = category) }
    }


}

@Composable
fun CategoryListItem(category: Category, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier.padding(2.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
        ) {
            Text(
                text = stringResource(id = category.stringRes),
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(start = 24.dp)
            )
            Spacer(Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.ChevronRight,

                    contentDescription = null
                )
            }
        }
    }

}

@Preview
@Composable
fun CategoryListItemPreview() {
    CategoryListItem(category = Category.BODY)
}

@Preview
@Composable
fun DisplayCategoryListPreview() {
    DisplayCategoryList()
}