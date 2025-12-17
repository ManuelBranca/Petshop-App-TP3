package com.example.petshopapptp3.components.profile

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens

@Composable
fun ModeButton(label: String, selected: Boolean, onClick: () -> Unit) {
    val d = rememberPhoneDimens()

    val background = if (selected) Color(0xFF7B61FF) else Color.LightGray
    val textColor = if (selected) Color.White else Color.Black

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = background),
        shape = RoundedCornerShape(d.cardRadius),
        modifier = Modifier.height(d.buttonHeight) // 👈 opcional pero recomendable
    ) {
        Text(label, color = textColor)
    }
}
