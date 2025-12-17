package com.example.petshopapptp3.components.homePage.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.petshopapptp3.R
import com.example.petshopapptp3.navigation.Screen
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens

@Composable
fun CartSummary(
    cartItems: List<CartItem>,
    totalPrice: Double,
    purple: Color,
    navController: NavController
) {
    val d = rememberPhoneDimens()
    val totalItems = cartItems.size

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(stringResource(R.string.total_items, totalItems))
            Text(stringResource(R.string.total_price, "%.2f".format(totalPrice)))
        }

        Spacer(modifier = Modifier.height(d.gap / 2))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(stringResource(R.string.tax))
            Text(stringResource(R.string.Cero))
        }

        Spacer(modifier = Modifier.height(d.gap))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(stringResource(R.string.totals), fontWeight = FontWeight.Bold)
            Text(
                stringResource(R.string.total_price, "%.2f".format(totalPrice)),
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(d.gapLg))

        Button(
            onClick = { navController.navigate(Screen.PaymentAdd.createRoute(false)) },
            modifier = Modifier
                .fillMaxWidth()
                .height(d.buttonHeight),
            colors = ButtonDefaults.buttonColors(containerColor = purple),
            shape = RoundedCornerShape(d.cardRadius)
        ) {
            Text(stringResource(R.string.checkout), color = Color.White, fontSize = 16.sp)
        }
    }
}
