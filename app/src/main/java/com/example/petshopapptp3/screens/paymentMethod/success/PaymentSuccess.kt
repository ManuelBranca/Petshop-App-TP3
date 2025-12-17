package com.example.petshopapptp3.screens.paymentMethod.success

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.petshopapptp3.R
import com.example.petshopapptp3.components.buttons.StartButton
import com.example.petshopapptp3.components.shared.SubtitleSection
import com.example.petshopapptp3.components.shared.TitleSection
import com.example.petshopapptp3.navigation.Screen

@Composable
fun PaymentSucces(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(top = 32.dp)
        ) {
            TitleSection(stringResource(R.string.payment_success))
            Spacer(modifier = Modifier.height(10.dp))
            SubtitleSection(stringResource(R.string.your_order_is_being_prepared_by_the_shop_the_courier_will_send_it_to_your_address))
        }

        Spacer(modifier = Modifier.height(24.dp))

        StartButton(stringResource(R.string.go_home), onClick = {
            navController.navigate(Screen.Home.route)
        })
    }
}

