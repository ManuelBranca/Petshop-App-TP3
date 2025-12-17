package com.example.petshopapptp3.screens.profilePage.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.petshopapptp3.R
import com.example.petshopapptp3.components.profile.ModeButton
import com.example.petshopapptp3.components.profile.StatItem
import com.example.petshopapptp3.components.profile.FilterChip
import com.example.petshopapptp3.components.shared.ProductRow
import com.example.petshopapptp3.navigation.Screen
import com.example.petshopapptp3.viewmodel.FavoritesViewModel
import com.example.petshopapptp3.viewmodel.ProductViewModel

@Composable
fun ProfileScreen(navController: NavController) {
    var isSellerMode by remember { mutableStateOf(false) }
    val viewModel: ProductViewModel = hiltViewModel()
    val products by viewModel.products.collectAsState()

    val backgroundColor = Color.White
    val purple = Color(0xFF7B61FF)

    val favVm: FavoritesViewModel = hiltViewModel()
    val favoriteIds by favVm.favoriteIds.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                // Header con botones de modo y settings
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        ModeButton(stringResource(R.string.profile), !isSellerMode) { isSellerMode = false }
                        ModeButton(stringResource(R.string.seller_mode), isSellerMode) { isSellerMode = true }
                    }

                    IconButton(onClick = { navController.navigate(Screen.Settings.route) }) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = stringResource(R.string.settings),
                            tint = Color.Black
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Imagen principal (avatar o logo)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(RoundedCornerShape(20.dp))
                ) {
                    val tintColor = if (!isSellerMode) Color(0xFFCEDDEF) else Color(0xFFFFD5B3)
                    val yOffset = 50.dp

                    Image(
                        painter = painterResource(id = R.drawable.fondo_avatar),
                        contentDescription = stringResource(R.string.fondo_decorativo),
                        modifier = Modifier
                            .matchParentSize()
                            .offset(y = yOffset)
                            .clip(RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.Crop,
                        colorFilter = ColorFilter.tint(tintColor.copy(alpha = 0.5f))
                    )

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        if (!isSellerMode) {
                            Image(
                                painter = painterResource(id = R.drawable.avatar4),
                                contentDescription = stringResource(R.string.avatar),
                                modifier = Modifier
                                    .size(100.dp)
                                    .offset(y = yOffset)
                                    .clip(CircleShape)
                            )
                        } else {
                            Image(
                                painter = painterResource(id = R.drawable.pittashop_logo),
                                contentDescription = stringResource(R.string.pittashop_logo),
                                modifier = Modifier
                                    .size(100.dp)
                                    .offset(y = yOffset)
                                    .clip(RoundedCornerShape(20.dp))
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))


                if (!isSellerMode) {
                    Text(stringResource(R.string.abduldul), fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        FilterChip(stringResource(R.string.saved), onClick = { })
                        FilterChip(stringResource(R.string.edit_profile), onClick = {
                            navController.navigate(Screen.Account.route)
                        })
                    }
                } else {

                    Text(stringResource(R.string.pittashop), fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        StatItem(stringResource(R.string._109), stringResource(R.string.followers))
                        StatItem(stringResource(R.string._992), stringResource(R.string.following))
                        StatItem(stringResource(R.string._80), stringResource(R.string.sales))
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        FilterChip(stringResource(R.string.product), onClick = {})
                        FilterChip(stringResource(R.string.sold), onClick = {})
                        FilterChip(stringResource(R.string.stats), onClick = {})
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }

            items(products.chunked(2)) { rowProducts ->
                ProductRow(
                    rowProducts = rowProducts,
                    purple = purple,
                    navController = navController ,
                    favoriteIds = favoriteIds,
                    onToggleFavorite = { product -> favVm.toggle(product) }
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

