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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petshopapptp3.R
import com.example.petshopapptp3.ui.theme.purple

@Composable
fun StartButton(
    Text: String = stringResource(R.string.onBoarding_Button),
    ButtonColor: Color = purple,
    TextColor: Color = Color.White,
    onClick: () -> Unit = {}
)
{
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = ButtonColor),
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(top = 32.dp)
    ) {
        Text(text = Text, color = TextColor)
    }
}

@Preview(showBackground = true)
@Composable
fun ShowButton(){
    StartButton(onClick = { })
}