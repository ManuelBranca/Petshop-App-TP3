package com.example.petshopapptp3.screens.profilePage.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.petshopapptp3.viewmodel.FavoritesViewModel
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.petshopapptp3.components.shared.ArrowTitle
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue

@Composable
fun FavoritesScreen(
    navController: NavController,
    favVm: FavoritesViewModel = hiltViewModel()
) {
    val favorites by favVm.favorites.collectAsState()

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        ArrowTitle("Favorites") { navController.popBackStack() }

        Spacer(Modifier.height(12.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(favorites) { item ->
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = item.thumbnail,
                        contentDescription = item.title,
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(Modifier.width(12.dp))
                    Column(Modifier.weight(1f)) {
                        Text(item.title, fontWeight = FontWeight.Bold)
                        Text("$${item.price}")
                    }
                    IconButton(onClick = { favVm.remove(item.id) }) {
                        Icon(Icons.Default.Delete, contentDescription = "Remove")
                    }
                }
            }
        }
    }
}
