package com.example.petshopapptp3.components.shared

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.petshopapptp3.navigation.Screen
import com.example.petshopapptp3.ui.theme.purple

@Composable
fun ClickeableText(text: String, onClick: () -> Unit) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall.copy(
            color = purple,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier.clickable(onClick = onClick)
    )
}
