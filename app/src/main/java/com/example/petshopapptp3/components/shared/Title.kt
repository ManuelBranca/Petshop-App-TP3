package com.example.petshopapptp3.components.shared

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.petshopapptp3.ui.theme.PhoneSize
import com.example.petshopapptp3.ui.theme.rememberPhoneSize

@Composable
fun TitleSection(
    title: String,
    fontSize: TextUnit? = null
) {
    val size = rememberPhoneSize()

    val responsiveSize = when (size) {
        PhoneSize.Small -> 28.sp
        PhoneSize.Normal -> 34.sp
        PhoneSize.Large -> 40.sp
    }

    Text(
        text = title,
        fontSize = fontSize ?: responsiveSize,
        fontWeight = FontWeight.Bold,
        color = Color.Black
    )
}
