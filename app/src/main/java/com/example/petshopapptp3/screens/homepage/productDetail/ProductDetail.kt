package com.example.petshopapptp3.screens.homepage.productDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.petshopapptp3.R
import com.example.petshopapptp3.components.buttons.StartButton
import com.example.petshopapptp3.components.shared.ArrowTitle
import com.example.petshopapptp3.data.remote.Product
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens
import com.example.petshopapptp3.viewmodel.CartViewModel
import com.example.petshopapptp3.viewmodel.FavoritesViewModel
import kotlinx.coroutines.launch

@Composable
fun ProductDetailScreen(
    product: Product,
    navController: NavController,
    cartViewModel: CartViewModel = hiltViewModel()
) {
    val d = rememberPhoneDimens()
    val purple = Color(0xFF7B61FF)

    var quantity by remember { mutableStateOf(1) }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    val favVm: FavoritesViewModel = hiltViewModel()
    val favoriteIds by favVm.favoriteIds.collectAsState()

    // tamaños escalados
    val heroHeight = when (d.pad.value.toInt()) {
        12 -> 190.dp // Small
        20 -> 250.dp // Large
        else -> 220.dp // Normal
    }
    val imageSize = when (d.pad.value.toInt()) {
        12 -> 130.dp
        20 -> 180.dp
        else -> 160.dp
    }

    val scrollState = rememberScrollState()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
                .verticalScroll(scrollState)
                .padding(d.pad)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ArrowTitle(stringResource(R.string.product_detail)) {
                    navController.popBackStack()
                }

                IconButton(onClick = { favVm.toggle(product) }) {
                    Icon(
                        imageVector = if (favoriteIds.contains(product.id)) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        modifier = Modifier.size(d.iconSize + 2.dp),
                        tint = if (favoriteIds.contains(product.id)) purple else Color.Unspecified
                    )
                }
            }

            Spacer(modifier = Modifier.height(d.gapLg))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(heroHeight)
                    .background(Color(0xFFF6F6F6), RoundedCornerShape(d.cardRadius)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberAsyncImagePainter(product.thumbnail),
                    contentDescription = product.title,
                    modifier = Modifier.size(imageSize)
                )
            }

            Spacer(modifier = Modifier.height(d.gapLg + d.gap))

            Text(
                text = product.title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(d.gap))

            Text(
                text = product.description,
                color = Color.Gray,
                fontSize = 14.sp,
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(d.gapLg + d.gap))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { if (quantity > 1) quantity-- }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = stringResource(R.string.decrease),
                            modifier = Modifier.size(d.iconSize + 2.dp)
                        )
                    }

                    Text(
                        text = quantity.toString(),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(horizontal = d.gap)
                    )

                    IconButton(onClick = { quantity++ }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = stringResource(R.string.increase),
                            modifier = Modifier.size(d.iconSize + 2.dp)
                        )
                    }
                }

                Text(
                    text = "$${product.price}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(d.gapLg + d.gap))

            StartButton(stringResource(R.string.add_to_cart)) {
                cartViewModel.addProductToCart(product, quantity)
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("Producto/s agregado/s al carrito")
                }
            }
            Spacer(modifier = Modifier.height(d.gapLg))
        }
    }
}
