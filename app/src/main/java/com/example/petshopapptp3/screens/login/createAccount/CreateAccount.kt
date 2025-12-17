package com.example.petshopapptp3.screens.login.createAccount

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun CreateAccount(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit,
    onLoginClick: () -> Unit,
    navController: NavController
) {
    val d = rememberPhoneDimens()

    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var fullNameError by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    val allFieldsValid = fullName.isNotBlank() && email.isNotBlank() && password.isNotBlank() && checked
    val buttonColor = if (allFieldsValid) purple else disableButton

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = d.pad + 8.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(d.gapLg * 2f))

        TitleSection(stringResource(R.string.createAccount_Title))

        Spacer(modifier = Modifier.height(d.gapLg))

        SubtitleSection(stringResource(R.string.login_SubTitle_General))

        Spacer(modifier = Modifier.height(d.gapLg))

        InputField(
            label = stringResource(R.string.full_name),
            value = fullName,
            onValueChange = {
                fullName = it
                if (it.isNotBlank()) fullNameError = false
            },
            isError = fullNameError
        )

        Spacer(modifier = Modifier.height(d.gapLg))

        InputField(
            label = stringResource(R.string.email),
            value = email,
            onValueChange = {
                email = it
                if (it.isNotBlank()) emailError = false
            },
            isError = emailError
        )

        Spacer(modifier = Modifier.height(d.gapLg))

        InputField(
            label = stringResource(R.string.password),
            value = password,
            onValueChange = {
                password = it
                if (it.isNotBlank()) passwordError = false
            },
            isPassword = true,
            isError = passwordError
        )

        Spacer(modifier = Modifier.height(d.gapLg))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = d.gap),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = checked, onCheckedChange = onCheckedChange)

            val termsText = stringResource(R.string.terms_of_service)
            val privacyText = stringResource(R.string.privacy_policy)
            val agree = stringResource(R.string.i_agree_to_the)
            val and = stringResource(R.string.and)
            val annotated = remember(termsText, privacyText) {
                buildAnnotatedString {
                    append(agree)
                    append(" ")

                    pushStringAnnotation(tag = "TERMS", annotation = "terms")
                    pushStyle(
                        SpanStyle(
                            color = purple,
                            textDecoration = TextDecoration.Underline,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    append(termsText)
                    pop()
                    pop()

                    append(" ")
                    append(and)
                    append(" ")

                    pushStringAnnotation(tag = "PRIVACY", annotation = "privacy")
                    pushStyle(
                        SpanStyle(
                            color = purple,
                            textDecoration = TextDecoration.Underline,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    append(privacyText)
                    pop()
                    pop()
                }
            }

            ClickableText(
                text = annotated,
                modifier = Modifier.padding(start = 6.dp),
                style = androidx.compose.ui.text.TextStyle(fontSize = 14.sp),
                onClick = { offset ->
                    annotated.getStringAnnotations(tag = "TERMS", start = offset, end = offset)
                        .firstOrNull()
                        ?.let { onTermsClick() }

                    annotated.getStringAnnotations(tag = "PRIVACY", start = offset, end = offset)
                        .firstOrNull()
                        ?.let { onPrivacyClick() }
                }
            )
        }

        Spacer(modifier = Modifier.height(d.gapLg))

        HaveAccount(onLoginClick = onLoginClick)

        Spacer(modifier = Modifier.height(d.gapLg))

        StartButton(
            buttonColor = buttonColor,
            onClick = {
                fullNameError = fullName.isBlank()
                emailError = email.isBlank()
                passwordError = password.isBlank()

                if (allFieldsValid) {
                    navController.navigate(Screen.Login.route)
                }
            }
        )

        Spacer(modifier = Modifier.height(d.gapLg))
    }
}
