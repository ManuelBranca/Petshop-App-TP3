package com.example.petshopapptp3.screens.profilePage.settingPage

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.petshopapptp3.R
import com.example.petshopapptp3.components.profile.SettingsRow
import com.example.petshopapptp3.components.shared.ArrowTitle
import com.example.petshopapptp3.navigation.Screen
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens

@Composable
fun SettingsScreen(navController: NavController) {
    val d = rememberPhoneDimens()
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(d.pad)
    ) {
        // ✅ Contenido scrolleable
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {
            ArrowTitle(stringResource(R.string.settings_page)) {
                navController.navigate(Screen.Profile.route)
            }

            Spacer(modifier = Modifier.height(d.gapLg))

            Text(
                text = stringResource(R.string.account),
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(d.gap))

            SettingsRow(stringResource(R.string.account), R.drawable.profile) {
                navController.navigate(Screen.Account.route)
            }
            SettingsRow(stringResource(R.string.address), R.drawable.home_active) {
                // TODO: NAVIGATION
            }
            SettingsRow(stringResource(R.string.notification), R.drawable.notification) {
                navController.navigate(Screen.SettingNotifications.route)
            }
            SettingsRow(stringResource(R.string.payment_method), R.drawable.wallet) {
                navController.navigate(Screen.PaymentAdd.createRoute(true))
            }
            SettingsRow(stringResource(R.string.privacy), R.drawable.danger_circle) {
                navController.navigate(Screen.TermsAndPrivacy.route)
            }
            SettingsRow(stringResource(R.string.security), R.drawable.key) {
                navController.navigate(Screen.Security.route)
            }

            Spacer(modifier = Modifier.height(d.gapLg))

            Text(
                text = stringResource(R.string.help),
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(d.gap))

            SettingsRow(stringResource(R.string.contact_us), R.drawable.phone) {
                // TODO: CONTACT US
            }
            SettingsRow(stringResource(R.string.faq), R.drawable.document) {
                navController.navigate(Screen.FAQ.route)
            }
            SettingsRow(stringResource(R.string.favorite), R.drawable.document) {
                navController.navigate(Screen.Favorites.route)
            }

            Spacer(modifier = Modifier.height(d.gapLg))
        }

        Button(
            onClick = { navController.navigate(Screen.Login.route) },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(d.buttonHeight)
        ) {
            Text(stringResource(R.string.log_out), color = Color(0xFF7B61FF))
        }
    }
}
