package com.example.petshopapptp3.components.homePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.petshopapptp3.R
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens

@Composable
fun CategorySection(purple: Color) {
    val d = rememberPhoneDimens()
    val gray = Color(0xFFF6F6F6)

    val categories = listOf(
        stringResource(R.string.food),
        stringResource(R.string.toys),
        stringResource(R.string.accessories)
    )

    var selectedIndex by remember { mutableStateOf(0) }

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                stringResource(R.string.category),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(stringResource(R.string.view_all), color = purple, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(d.gap))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()), // 👈 clave para phones chicos
            horizontalArrangement = Arrangement.spacedBy(d.gap),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Ícono no seleccionable
            Box(
                modifier = Modifier
                    .height(d.inputHeight * 0.75f) // antes 40.dp
                    .widthIn(min = d.iconSize * 2.4f) // antes min 48.dp
                    .background(gray, RoundedCornerShape(d.cardRadius)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.swap),
                    contentDescription = stringResource(R.string.swap),
                    modifier = Modifier.size(d.iconSize), // antes 20.dp
                    colorFilter = ColorFilter.tint(Color.Black)
                )
            }

            categories.forEachIndexed { index, text ->
                val isSelected = selectedIndex == index

                Box(
                    modifier = Modifier
                        .height(d.inputHeight * 0.75f) // antes 40.dp
                        .background(
                            color = if (isSelected) purple else gray,
                            shape = RoundedCornerShape(d.cardRadius)
                        )
                        .clickable { selectedIndex = index }
                        .padding(horizontal = d.gapLg), // antes 20.dp
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = text,
                        color = if (isSelected) Color.White else Color.Gray,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}
