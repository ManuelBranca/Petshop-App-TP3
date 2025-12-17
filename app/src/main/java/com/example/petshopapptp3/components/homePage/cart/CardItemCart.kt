package com.example.petshopapptp3.screens.homepage.cart

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.example.petshopapptp3.data.local.CartItemEntity
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens

@Composable
fun CartItemCard(item: CartItemEntity) {
    val d = rememberPhoneDimens()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(d.cardPad)
    ) {
        AsyncImage(
            model = item.thumbnail,
            contentDescription = item.title,
            modifier = Modifier.size(d.iconSize * 3)
        )

        Spacer(modifier = Modifier.width(d.gap))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(d.gap / 2)
        ) {
            Text(text = item.title)
            Text(text = "Qty: ${item.quantity}")
            Text(text = "$${item.price}")
        }
    }
}
