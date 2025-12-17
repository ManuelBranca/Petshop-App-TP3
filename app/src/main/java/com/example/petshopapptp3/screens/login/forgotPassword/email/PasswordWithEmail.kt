package com.example.petshopapptp3.screens.login.forgotPassword.email

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.petshopapptp3.R
import com.example.petshopapptp3.components.buttons.StartButton
import com.example.petshopapptp3.components.loginComponents.HaveAccount
import com.example.petshopapptp3.components.shared.InputField
import com.example.petshopapptp3.components.shared.SubtitleSection
import com.example.petshopapptp3.components.shared.TitleSection
import com.example.petshopapptp3.navigation.Screen
import com.example.petshopapptp3.ui.theme.disableButton
import com.example.petshopapptp3.ui.theme.purple
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens

@Composable
fun PasswordWithEmail(onLoginClick: () -> Unit, navController: NavController) {
    val d = rememberPhoneDimens()

    var email by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf(false) }

    val isValid = email.isNotBlank()
    val buttonColor = if (isValid) purple else disableButton

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = d.pad + 8.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(d.gapLg * 2f)) // antes 50.dp aprox

        TitleSection(stringResource(R.string.forgot_password))

        Spacer(modifier = Modifier.height(d.gapLg))

        SubtitleSection(stringResource(R.string.login_SubTitle_General))

        Spacer(modifier = Modifier.height(d.gapLg))

        InputField(
            value = email,
            onValueChange = {
                email = it
                if (it.isNotBlank()) emailError = false
            },
            isError = emailError,
            showError = true
        )

        Spacer(modifier = Modifier.weight(1f))

        HaveAccount(onLoginClick = { navController.navigate(Screen.Login.route) })

        Spacer(modifier = Modifier.height(d.gap))

        StartButton(
            text = "Next",
            buttonColor = buttonColor,
            onClick = {
                emailError = email.isBlank()
                if (isValid) {
                    navController.navigate(Screen.NewPassword.route)
                }
            }
        )

        Spacer(modifier = Modifier.height(d.gapLg))
    }
}
