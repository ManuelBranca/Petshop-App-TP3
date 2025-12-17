package com.example.petshopapptp3.components.shared

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.petshopapptp3.R
import com.example.petshopapptp3.navigation.Screen
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens

@Composable
fun HomeTopBar(
    navController: NavController,
    onLocationClick: () -> Unit
) {
    val d = rememberPhoneDimens()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = d.pad, vertical = d.topBarPad),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.clickable { onLocationClick() }
        ) {
            Text(
                stringResource(R.string.location),
                fontSize = 12.sp,
                color = Color.Gray
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    stringResource(R.string.jebres_surakarta),
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier.size(d.iconSize)
                )
            }
        }

        Row {
            IconButton(onClick = { navController.navigate(Screen.Search.route) }) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.size(d.iconSize)
                )
            }
            IconButton(onClick = { navController.navigate(Screen.Notification.route) }) {
                Icon(
                    Icons.Default.Notifications,
                    contentDescription = null,
                    modifier = Modifier.size(d.iconSize)
                )
            }
        }
    }
}
