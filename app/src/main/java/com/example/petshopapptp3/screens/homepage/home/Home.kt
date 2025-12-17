package com.example.petshopapptp3.screens.homepage.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.petshopapptp3.components.homePage.BestSellerHeader
import com.example.petshopapptp3.components.homePage.CategorySection
import com.example.petshopapptp3.components.homePage.PromoCard
import com.example.petshopapptp3.components.shared.HomeTopBar
import com.example.petshopapptp3.components.shared.ProductRow
import com.example.petshopapptp3.navigation.Screen
import com.example.petshopapptp3.screens.homepage.location.Location
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens
import com.example.petshopapptp3.viewmodel.FavoritesViewModel
import com.example.petshopapptp3.viewmodel.ProductViewModel

@Composable
fun HomeScreen(navController: NavController) {
    val d = rememberPhoneDimens()
    val purple = Color(0xFF7B61FF)

    val productVm: ProductViewModel = hiltViewModel()
    val products by productVm.products.collectAsState()

    val favVm: FavoritesViewModel = hiltViewModel()
    val favoriteIds by favVm.favoriteIds.collectAsState()

    var showLocationModal by remember { mutableStateOf(false) }
    if (showLocationModal) Location(onDismiss = { showLocationModal = false })

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentPadding = PaddingValues(d.pad),
        verticalArrangement = Arrangement.spacedBy(d.gapLg)
    ) {
        item { HomeTopBar(navController, onLocationClick = { showLocationModal = true }) }
        item { PromoCard(purple) }
        item { CategorySection(purple) }
        item { BestSellerHeader(purple) { navController.navigate(Screen.BestSeller.route) } }

        items(products.take(6).chunked(2)) { rowProducts ->
            ProductRow(
                rowProducts = rowProducts,
                purple = purple,
                navController = navController,
                favoriteIds = favoriteIds,
                onToggleFavorite = { product -> favVm.toggle(product) }
            )
        }

        item { Spacer(modifier = Modifier.height(d.gapLg * 1.5f)) } // antes 24.dp
    }
}

@Preview(showBackground = true)
@Composable
fun ShowHomeScreen() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}
