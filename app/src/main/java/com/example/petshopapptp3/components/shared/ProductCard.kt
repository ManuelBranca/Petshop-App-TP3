package com.example.petshopapptp3.components.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.petshopapptp3.R
import com.example.petshopapptp3.data.remote.Product
import com.example.petshopapptp3.ui.theme.cardColor
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens

@Composable
fun ProductCard(
    product: Product,
    purple: Color,
    gray: Color,
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    onClick: () -> Unit
) {
    val d = rememberPhoneDimens()
    val shape = RoundedCornerShape(d.cardRadius)

    Box(
        modifier = modifier
            .clickable { onClick() }
            .background(cardColor, shape)
            .border(1.dp, gray, shape)
            .padding(d.cardPad)
    ) {
        IconButton(
            onClick = onFavoriteClick,
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            Icon(
                imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = stringResource(R.string.favorite),
                modifier = Modifier.size(d.iconSize)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = product.thumbnail,
                contentDescription = product.title,
                modifier = Modifier.size(d.iconSize * 4.5f) // antes 100.dp aprox
            )

            Spacer(modifier = Modifier.height(d.gap))

            Text(product.title, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text("$${product.price}", fontSize = 14.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(d.gap))

            Box(
                modifier = Modifier
                    .size(d.iconSize * 1.6f) // antes 32.dp aprox
                    .background(purple, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(d.iconSize * 0.9f)
                )
            }
        }
    }
}
