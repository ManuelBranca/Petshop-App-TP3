package com.example.petshopapptp3.components.loginComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.petshopapptp3.R
import com.example.petshopapptp3.components.shared.ClickeableText
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens

@Composable
fun HaveAccount(onLoginClick: () -> Unit) {
    val d = rememberPhoneDimens()

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.have_an_account),
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.width(d.gap / 2))
        ClickeableText(stringResource(R.string.login), onClick = onLoginClick)
    }
}
