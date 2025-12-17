package com.example.petshopapptp3.screens.homepage.bestSeller

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.petshopapptp3.R
import com.example.petshopapptp3.components.shared.ArrowTitle
import com.example.petshopapptp3.components.shared.ProductCard
import com.example.petshopapptp3.navigation.Screen
import com.example.petshopapptp3.ui.theme.PhoneSize
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens
import com.example.petshopapptp3.ui.theme.rememberPhoneSize
import com.example.petshopapptp3.viewmodel.FavoritesViewModel
import com.example.petshopapptp3.viewmodel.ProductViewModel


import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.petshopapptp3.ui.theme.PetshopAppTP3Theme
import com.example.petshopapptp3.data.remote.Product


@Composable
fun BestSellerScreen(navController: NavController) {
    val vm: ProductViewModel = viewModel()
    val products by vm.products.collectAsState()

    val favVm: FavoritesViewModel = hiltViewModel()
    val favoriteIds by favVm.favoriteIds.collectAsState()

    BestSellerContent(
        navController = navController,
        products = products,
        favoriteIds = favoriteIds,
        onToggleFavorite = { favVm.toggle(it) }
    )
}

@Composable
private fun BestSellerContent(
    navController: NavController,
    products: List<com.example.petshopapptp3.data.remote.Product>,
    favoriteIds: Set<Int>,
    onToggleFavorite: (com.example.petshopapptp3.data.remote.Product) -> Unit
) {
    val d = rememberPhoneDimens()
    val size = rememberPhoneSize()

    val purple = Color(0xFF7B61FF)
    val gray = Color(0xFFF6F6F6)

    val columns = when (size) {
        PhoneSize.Small -> 1
        PhoneSize.Normal -> 2
        PhoneSize.Large -> 3
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(d.pad),
        verticalArrangement = Arrangement.spacedBy(d.gapLg)
    ) {
        item {
            ArrowTitle(stringResource(R.string.best_seller)) {
                navController.popBackStack()
            }
            Spacer(modifier = Modifier.height(d.gapLg))
        }

        items(products.chunked(columns)) { rowProducts ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(d.gap)
            ) {
                rowProducts.forEach { product ->
                    ProductCard(
                        product = product,
                        purple = purple,
                        gray = gray,
                        modifier = Modifier.weight(1f),
                        isFavorite = favoriteIds.contains(product.id),
                        onFavoriteClick = { onToggleFavorite(product) },
                        onClick = {
                            navController.navigate(Screen.ProductDetail.createRoute(product.id))
                        }
                    )
                }

                repeat(columns - rowProducts.size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }

        item { Spacer(modifier = Modifier.height(d.gapLg)) }
    }
}
