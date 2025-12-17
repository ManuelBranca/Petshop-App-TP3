package com.example.petshopapptp3.components.loginComponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.petshopapptp3.R
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens

@Composable
fun DividerWithOr() {
    val d = rememberPhoneDimens()

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        HorizontalDivider(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(R.string.or),
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier
                .then(Modifier)
        )
        HorizontalDivider(modifier = Modifier.weight(1f))
    }
}
