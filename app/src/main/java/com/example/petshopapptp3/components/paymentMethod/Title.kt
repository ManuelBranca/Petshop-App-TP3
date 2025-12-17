package com.example.petshopapptp3.components.paymentMethod

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.petshopapptp3.ui.theme.PhoneSize
import com.example.petshopapptp3.ui.theme.rememberPhoneSize

@Composable
fun PaymentTitle(text: String) {
    val size = rememberPhoneSize()

    val titleSize = when (size) {
        PhoneSize.Small -> 24.sp
        PhoneSize.Normal -> 28.sp
        PhoneSize.Large -> 32.sp
    }

    Text(
        text = text,
        fontSize = titleSize,
        fontWeight = FontWeight.Bold,
        color = Color.Black
    )
}
