package com.example.petshopapptp3.components.shared

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopapptp3.R
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens

@Composable
fun BottomNavBar(
    selectedItem: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val d = rememberPhoneDimens()

    val items = listOf(
        stringResource(R.string.home),
        stringResource(R.string.chat),
        stringResource(R.string.bag),
        stringResource(R.string.profile)
    )

    NavigationBar(
        containerColor = Color(0xFFF8F8F8),
        modifier = modifier
    ) {
        items.forEachIndexed { index, _ ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = { onItemSelected(index) },
                icon = {
                    val iconSize = d.iconSize * 1.15f // parecido a 24dp en normal

                    when (index) {
                        0 -> Icon(
                            painter = painterResource(R.drawable.home_active),
                            contentDescription = stringResource(R.string.home),
                            modifier = Modifier.size(iconSize)
                        )

                        1 -> Icon(
                            painter = painterResource(R.drawable.time_circle),
                            contentDescription = stringResource(R.string.chat),
                            modifier = Modifier.size(iconSize)
                        )

                        2 -> Icon(
                            painter = painterResource(R.drawable.bag),
                            contentDescription = stringResource(R.string.bag),
                            modifier = Modifier.size(iconSize)
                        )

                        3 -> Icon(
                            painter = painterResource(R.drawable.profile),
                            contentDescription = stringResource(R.string.profile),
                            modifier = Modifier.size(iconSize)
                        )
                    }
                },
                alwaysShowLabel = false
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowNavBar() {
    BottomNavBar(1, onItemSelected = {})
}
