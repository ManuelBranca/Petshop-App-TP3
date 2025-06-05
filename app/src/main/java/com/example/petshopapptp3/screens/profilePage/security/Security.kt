package com.example.petshopapptp3.screens.profilePage.security

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.petshopapptp3.R
import com.example.petshopapptp3.components.shared.ArrowTitle
import com.example.petshopapptp3.navigation.Screen

@Composable
fun SecurityScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        ArrowTitle("Security"){
            navController.popBackStack()
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Security",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 4.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        SecurityOptionRow(
            iconResId = R.drawable.ic_lock,
            label = "Change Password",
            onClick = { navController.navigate(Screen.ChangePassword.route) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        SecurityOptionRow(
            iconResId = R.drawable.ic_lock,
            label = "Change Email",
            onClick = { navController.navigate(Screen.ChangeEmail.route) }
        )
    }
}

@Composable
fun SecurityOptionRow(
    iconResId: Int,
    label: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color(0xFFF6F6F6)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                tint = Color.Black
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(1f)
        )

        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = null
        )
    }
}
