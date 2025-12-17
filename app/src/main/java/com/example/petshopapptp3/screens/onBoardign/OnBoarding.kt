package com.example.petshopapptp3.screens.onBoardign

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.petshopapptp3.R
import com.example.petshopapptp3.components.buttons.StartButton
import com.example.petshopapptp3.navigation.Screen
import com.example.petshopapptp3.ui.theme.PhoneSize
import com.example.petshopapptp3.ui.theme.purple
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens
import com.example.petshopapptp3.ui.theme.rememberPhoneSize

@Composable
fun OnBoarding(navController: NavController) {
    val d = rememberPhoneDimens()
    val size = rememberPhoneSize()

    val titleSize = when (size) {
        PhoneSize.Small -> 28.sp
        PhoneSize.Normal -> 34.sp
        PhoneSize.Large -> 40.sp
    }

    val imageSize = when (size) {
        PhoneSize.Small -> 240.dp
        PhoneSize.Normal -> 300.dp
        PhoneSize.Large -> 350.dp
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // ✅ evita cortes en pantallas chicas
            .wrapContentSize(Alignment.Center)
            .padding(horizontal = d.pad, vertical = d.pad),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            style = MaterialTheme.typography.bodyLarge,
            text = stringResource(R.string.onBoarding_Title),
            fontSize = titleSize,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = d.gapLg)
        )

        Spacer(modifier = Modifier.height(d.gap))

        Image(
            painter = painterResource(id = R.drawable.illustration),
            contentDescription = stringResource(R.string.illustration),
            modifier = Modifier
                .size(imageSize)
                .padding(top = d.gapLg)
        )

        Spacer(modifier = Modifier.height(d.gap))

        Text(
            style = MaterialTheme.typography.bodyLarge,
            text = stringResource(R.string.onBoarding_Subtitle),
            fontSize = 14.sp,
            lineHeight = 18.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = d.gapLg)
        )

        Spacer(modifier = Modifier.height(d.gap))

        Text(
            text = stringResource(R.string.welcome_circles),
            fontSize = 18.sp,
            color = purple,
            modifier = Modifier.padding(top = d.gapLg)
        )

        StartButton(onClick = { navController.navigate(Screen.Login.route) })
    }
}
