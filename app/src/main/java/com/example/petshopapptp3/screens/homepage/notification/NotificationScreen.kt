package com.example.petshopapptp3.screens.homepage.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.petshopapptp3.R
import com.example.petshopapptp3.components.homePage.notification.NotificationData
import com.example.petshopapptp3.components.homePage.notification.NotificationList
import com.example.petshopapptp3.components.shared.ArrowTitle
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(navController: NavController) {
    val d = rememberPhoneDimens()
    var selectedTab by remember { mutableStateOf(0) }

    val tabTitles = listOf(
        stringResource(R.string.activity),
        stringResource(R.string.seller_mode)
    )

    val activityItems = List(4) {
        NotificationData(
            stringResource(R.string.sale_50),
            stringResource(R.string.check_the_details),
            R.drawable.comida_canina
        )
    }

    val sellerItems = listOf(
        NotificationData(
            stringResource(R.string.you_got_new_order),
            stringResource(R.string.please_arrange_delivery),
            R.drawable.comida_canina
        ),
        NotificationData(stringResource(R.string.momon), stringResource(R.string.liked_your_product), R.drawable.avatar1),
        NotificationData(stringResource(R.string.ola), stringResource(R.string.liked_your_product), R.drawable.avatar2),
        NotificationData(stringResource(R.string.raul), stringResource(R.string.liked_your_product), R.drawable.avatar3),
        NotificationData(
            stringResource(R.string.you_got_new_order),
            stringResource(R.string.please_arrange_delivery),
            R.drawable.comida_canina
        ),
        NotificationData(stringResource(R.string.vito), stringResource(R.string.liked_your_product), R.drawable.avatar4),
    )

    Scaffold(
        topBar = {
            ArrowTitle(stringResource(R.string.notification)) {
                navController.popBackStack()
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

            Row(
                modifier = Modifier
                    .padding(horizontal = d.pad, vertical = d.topBarPad)
                    .height(d.inputHeight - 12.dp) // aprox equivalente a 40.dp, escalado
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFF1F1F1),
                        shape = MaterialTheme.shapes.large
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                tabTitles.forEachIndexed { index, title ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clickable { selectedTab = index }
                            .background(
                                color = if (selectedTab == index) Color(0xFF7C3AED) else Color.Transparent,
                                shape = MaterialTheme.shapes.large
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = title,
                            color = if (selectedTab == index) Color.White else Color.Gray,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            val itemsToShow = if (selectedTab == 0) activityItems else sellerItems

            LazyColumn(
                modifier = Modifier.padding(horizontal = d.pad, vertical = d.gap),
                contentPadding = PaddingValues(bottom = d.gapLg),
                verticalArrangement = Arrangement.spacedBy(d.gap)
            ) {
                items(itemsToShow) { item ->
                    NotificationList(item)
                }
            }
        }
    }
}
