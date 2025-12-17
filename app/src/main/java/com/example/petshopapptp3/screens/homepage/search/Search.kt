package com.example.petshopapptp3.screens.homepage.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.petshopapptp3.R
import com.example.petshopapptp3.components.shared.ArrowTitle
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens
import androidx.compose.foundation.layout.FlowRow

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SearchScreen(navController: NavController) {
    val d = rememberPhoneDimens()
    var searchQuery by remember { mutableStateOf("") }

    val categories = listOf(
        stringResource(R.string.feed),
        stringResource(R.string.toys),
        stringResource(R.string.accessories)
    )
    var selectedCategory by remember { mutableStateOf(categories.first()) }

    val royal = stringResource(R.string.royal_canin_persian_500g)

    var recentSearches by remember {
        mutableStateOf(
            listOf(
                royal,
                royal,
                royal
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = d.pad, vertical = d.topBarPad)
    ) {
        ArrowTitle(stringResource(R.string.search)) {
            navController.popBackStack()
        }

        Spacer(modifier = Modifier.height(d.gap))

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text(stringResource(R.string.search_your_product)) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.size(d.iconSize)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = d.inputHeight),
            shape = RoundedCornerShape(d.cardRadius - 4.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF7B61FF),
                unfocusedBorderColor = Color(0xFFE0E0E0)
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(d.gapLg))

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(d.gap),
            verticalArrangement = Arrangement.spacedBy(d.gap)
        ) {
            categories.forEach { category ->
                val isSelected = selectedCategory == category
                FilterChip(
                    selected = isSelected,
                    onClick = { selectedCategory = category },
                    label = { Text(category) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFF7B61FF),
                        selectedLabelColor = Color.White,
                        containerColor = Color(0xFFF0F0F0),
                        labelColor = Color.Black
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(d.gapLg + d.gap))

        Text(
            text = "Recent",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(d.gap))

        Column(verticalArrangement = Arrangement.spacedBy(d.gap)) {
            recentSearches.forEach { search ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = search,
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(
                        onClick = { recentSearches = recentSearches - search },
                        modifier = Modifier.size(d.iconSize * 2f)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = stringResource(R.string.remove),
                            modifier = Modifier.size(d.iconSize)
                        )
                    }
                }
            }
        }
    }
}
