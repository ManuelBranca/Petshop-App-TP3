package com.example.petshopapptp3.screens.profilePage.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.petshopapptp3.R
import com.example.petshopapptp3.components.buttons.StartButton
import com.example.petshopapptp3.components.shared.ArrowTitle
import com.example.petshopapptp3.components.shared.InputField
import com.example.petshopapptp3.navigation.Screen

@Composable
fun AccountScreen(navController: NavController) {
    val abdul = stringResource(R.string.abdul)
    var name by remember { mutableStateOf(abdul) }
    var username by remember { mutableStateOf(abdul) }
    var email by remember { mutableStateOf(abdul) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            ArrowTitle(text = stringResource(R.string.account)) {
                navController.navigate(Screen.Settings.route)
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(20.dp))
            ) {
                val yOffset = 50.dp

                Image(
                    painter = painterResource(id = R.drawable.fondo_avatar),
                    contentDescription = stringResource(R.string.fondo_decorativo),
                    modifier = Modifier
                        .matchParentSize()
                        .offset(y = yOffset)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop,
                )

                IconButton(
                    onClick = { /* Edit background */ },
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.edit),
                        contentDescription = stringResource(R.string.editar_fondo)
                    )
                }

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .offset(y = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.avatar4),
                        contentDescription = stringResource(R.string.avatar),
                        modifier = Modifier
                            .clip(RoundedCornerShape(100))
                            .height(80.dp)
                    )

                    Text(
                        text = stringResource(R.string.abduldul),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(60.dp))

            InputField(label = stringResource(R.string.name), value = name, onValueChange = { name = it })
            Spacer(modifier = Modifier.height(12.dp))
            InputField(label = stringResource(R.string.username), value = username, onValueChange = { username = it })
            Spacer(modifier = Modifier.height(12.dp))
            InputField(label = stringResource(R.string.email), value = email, onValueChange = { email = it })
        }

        StartButton(
            text = stringResource(R.string.save_changes),
            onClick = {
                navController.navigate(Screen.Profile.route)
            }
        )
    }
}
