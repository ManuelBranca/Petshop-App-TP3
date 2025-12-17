package com.example.petshopapptp3.components.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens

@Composable
fun FilterChip(label: String, onClick: () -> Unit) {
    val d = rememberPhoneDimens()

    Box(
        modifier = Modifier
            .background(Color(0xFFF1F1F1), shape = RoundedCornerShape(d.cardRadius))
            .padding(horizontal = d.gapLg, vertical = d.gap / 2)
    ) {
        Text(label, fontSize = 14.sp)
    }
}
