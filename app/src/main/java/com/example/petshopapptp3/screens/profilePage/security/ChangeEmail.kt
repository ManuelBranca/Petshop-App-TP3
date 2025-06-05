// ChangeEmailScreen.kt
package com.example.petshopapptp3.screens.profilePage.security

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.petshopapptp3.components.shared.ArrowTitle


@Composable
fun ChangeEmailScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            ArrowTitle("Change Email") {
                navController.popBackStack()
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "New Email",
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Abdul", color = Color.LightGray) },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(12.dp)),
                colors = TextFieldDefaults.colors(Color.White)
            )
        }

        Button(
            onClick = { /* TODO: guardar */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp)
                .height(56.dp),
            shape = RoundedCornerShape(28.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7B61FF))
        ) {
            Text("Save", color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}
