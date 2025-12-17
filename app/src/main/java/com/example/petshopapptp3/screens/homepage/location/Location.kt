package com.example.petshopapptp3.screens.homepage.location

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
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
import com.example.petshopapptp3.R
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Location(onDismiss: () -> Unit) {
    val d = rememberPhoneDimens()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        shape = RoundedCornerShape(topStart = d.cardRadius + 8.dp, topEnd = d.cardRadius + 8.dp),
        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(d.pad + 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(width = d.iconSize * 2f, height = 4.dp)
                    .background(Color.LightGray, RoundedCornerShape(2.dp))
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(d.gapLg))

            Text(
                text = stringResource(R.string.location),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(d.gapLg))

            var searchText by remember { mutableStateOf("") }

            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = { Text(stringResource(R.string.search_your_location)) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.size(d.iconSize)
                    )
                },
                shape = RoundedCornerShape(d.cardRadius - 4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = d.inputHeight),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFE0E0E0),
                    focusedBorderColor = Color(0xFF7B61FF)
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(d.gapLg + 8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { }
                    .padding(vertical = d.gap),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(d.iconSize)
                )
                Spacer(modifier = Modifier.width(d.gap))
                Column {
                    Text(
                        text = stringResource(R.string.track_your_location),
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = stringResource(R.string.automatically_selects_your_current_location),
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(d.gapLg * 2f))
        }
    }
}
