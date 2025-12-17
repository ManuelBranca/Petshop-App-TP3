package com.example.petshopapptp3.components.homePage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.petshopapptp3.R
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens

@Composable
fun BestSellerHeader(purple: Color, onViewAllClick: () -> Unit) {
    val d = rememberPhoneDimens()

    Column {
        Spacer(modifier = Modifier.height(d.gap))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(stringResource(R.string.best_seller), fontWeight = FontWeight.Bold)

            Text(
                stringResource(R.string.view_all),
                color = purple,
                fontSize = 12.sp,
                modifier = Modifier.clickable { onViewAllClick() }
            )
        }
    }
}
