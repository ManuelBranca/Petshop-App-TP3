package com.example.petshopapptp3.screens.login.loginScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petshopapptp3.components.buttons.StartButton
import com.example.petshopapptp3.components.loginComponents.BottomText
import com.example.petshopapptp3.components.loginComponents.DividerWithOr
import com.example.petshopapptp3.components.loginComponents.SocialButtons
import com.example.petshopapptp3.components.shared.InputField
import com.example.petshopapptp3.components.shared.SubtitleSection
import com.example.petshopapptp3.components.shared.TitleSection
import com.example.petshopapptp3.R
import com.example.petshopapptp3.components.shared.ClickeableText
import com.example.petshopapptp3.navigation.Screen
import com.example.petshopapptp3.ui.theme.disableButton
import com.example.petshopapptp3.ui.theme.purple
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    val allFieldsFilled = email.isNotBlank() && password.isNotBlank()
    val buttonColor = if (allFieldsFilled) purple else disableButton

    val context = LocalContext.current
    val auth = remember { FirebaseAuth.getInstance() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(25.dp))
        TitleSection(stringResource(R.string.login_Title))
        Spacer(modifier = Modifier.height(16.dp))
        SubtitleSection(stringResource(R.string.login_SubTitle_General))
        Spacer(modifier = Modifier.height(15.dp))

        InputField(
            label = "Email",
            value = email,
            onValueChange = {
                email = it
                if (it.isNotBlank()) emailError = false
            },
            isError = emailError,
            showError = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        InputField(
            label = stringResource(R.string.password),
            value = password,
            onValueChange = {
                password = it
                if (it.isNotBlank()) passwordError = false
            },
            isPassword = true,
            isError = passwordError,
            showError = true
        )

        Spacer(modifier = Modifier.height(15.dp))
        DividerWithOr()
        Spacer(modifier = Modifier.height(15.dp))
        SocialButtons()
        Spacer(modifier = Modifier.height(15.dp))
        ClickeableText(stringResource(R.string.forgot_password), onClick = {
            navController.navigate(Screen.ForgotPasswordEmail.route)
        })
        Spacer(modifier = Modifier.height(15.dp))
        BottomText(onClick = {
            navController.navigate(Screen.CreateAccount.route)
        })
        Spacer(modifier = Modifier.height(25.dp))

        StartButton(
            buttonColor = buttonColor,
            onClick = {
                emailError = email.isBlank()
                passwordError = password.isBlank()

                if (!allFieldsFilled) return@StartButton

                auth.signInWithEmailAndPassword(email.trim(), password)
                    .addOnSuccessListener {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Login.route) { inclusive = true }
                            launchSingleTop = true
                        }
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(context, e.message ?: context.getString(R.string.error_al_iniciar_sesi_n), Toast.LENGTH_LONG).show()
                    }
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ShowLoginScreen(){
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}