package com.example.petshopapptp3.components.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.petshopapptp3.ui.theme.PhoneSize
import com.example.petshopapptp3.ui.theme.rememberPhoneSize

@Composable
fun StatItem(value: String, label: String) {
    val size = rememberPhoneSize()

    val valueSize = when (size) {
        PhoneSize.Small -> 16.sp
        PhoneSize.Normal -> 18.sp
        PhoneSize.Large -> 20.sp
    }

    val labelSize = when (size) {
        PhoneSize.Small -> 11.sp
        PhoneSize.Normal -> 12.sp
        PhoneSize.Large -> 13.sp
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, fontWeight = FontWeight.Bold, fontSize = valueSize)
        Text(label, color = Color.Gray, fontSize = labelSize)
    }
}
