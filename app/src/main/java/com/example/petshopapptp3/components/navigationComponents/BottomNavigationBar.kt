package com.example.petshopapptp3.components.navigationComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.petshopapptp3.navigation.Screen
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens

@Composable
fun BottomNavigationBar(navController: NavController) {
    val d = rememberPhoneDimens()

    val items = listOf(
        Screen.Home to Icons.Default.Home,
        Screen.Cart to Icons.Default.ShoppingCart,
        Screen.Profile to Icons.Default.Person
    )

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar(
        containerColor = Color.White,
        tonalElevation = d.gapLg // antes 8.dp
    ) {
        items.forEach { (screen, icon) ->
            val isSelected = currentRoute == screen.route

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = icon,
                            contentDescription = screen.route,
                            tint = if (isSelected) Color(0xFF7A42F4) else Color(0xFFBDBDBD),
                            modifier = Modifier.size(d.iconSize * 1.15f) // antes 24.dp
                        )

                        if (isSelected) {
                            Box(
                                modifier = Modifier
                                    .padding(top = d.gap / 3)
                                    .size(d.gap / 2) // antes 6.dp aprox
                                    .clip(CircleShape)
                                    .background(Color(0xFF7A42F4))
                            )
                        } else {
                            Spacer(modifier = Modifier.height(d.gap)) // antes 10.dp
                        }
                    }
                },
                alwaysShowLabel = false
            )
        }
    }
}
