package com.example.petshopapptp3.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.petshopapptp3.R
import com.example.petshopapptp3.ui.theme.purple
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens

@Composable
fun StartButton(
    text: String = stringResource(R.string.onBoarding_Button),
    buttonColor: Color = purple,
    textColor: Color = Color.White,
    onClick: () -> Unit = {}
) {
    val d = rememberPhoneDimens()

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        shape = RoundedCornerShape(d.cardRadius),
        modifier = Modifier
            .fillMaxWidth()
            .height(d.buttonHeight)
            .padding(top = d.gapLg)
    ) {
        Text(text = text, color = textColor)
    }
}

@Preview(showBackground = true)
@Composable
fun ShowButton() {
    StartButton(onClick = {})
}
