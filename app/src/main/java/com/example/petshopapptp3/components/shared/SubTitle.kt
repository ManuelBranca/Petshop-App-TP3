package com.example.petshopapptp3.components.shared

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.padding
import com.example.petshopapptp3.ui.theme.PhoneSize
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens
import com.example.petshopapptp3.ui.theme.rememberPhoneSize

@Composable
fun SubtitleSection(subtitle: String) {
    val d = rememberPhoneDimens()
    val size = rememberPhoneSize()

    val font = when (size) {
        PhoneSize.Small -> 16.sp
        PhoneSize.Normal -> 18.sp
        PhoneSize.Large -> 20.sp
    }

    val line = when (size) {
        PhoneSize.Small -> 18.sp
        PhoneSize.Normal -> 20.sp
        PhoneSize.Large -> 22.sp
    }

    Text(
        text = subtitle,
        fontSize = font,
        color = Color.Gray,
        style = MaterialTheme.typography.bodySmall,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(top = d.gapLg),
        lineHeight = line
    )
}
