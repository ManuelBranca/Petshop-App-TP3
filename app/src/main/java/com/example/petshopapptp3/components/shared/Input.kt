package com.example.petshopapptp3.components.shared

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.petshopapptp3.R
import com.example.petshopapptp3.ui.theme.purple
import com.example.petshopapptp3.ui.theme.rememberPhoneDimens

@Composable
fun InputField(
    label: String = stringResource(R.string.email),
    value: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false,
    isError: Boolean = false,
    showError: Boolean = false
) {
    val d = rememberPhoneDimens()

    Column {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(label) },

            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = d.inputHeight),
            shape = RoundedCornerShape(d.cardRadius),
            singleLine = true,
            isError = isError,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                disabledTextColor = Color.Gray,

                cursorColor = purple,

                focusedBorderColor = purple,
                unfocusedBorderColor = Color.LightGray,
                errorBorderColor = Color.Red,

                focusedPlaceholderColor = Color.Gray,
                unfocusedPlaceholderColor = Color.Gray,

                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White
            )
        )

        if (showError && isError) {
            Text(
                text = stringResource(R.string.campo_requerido),
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = d.pad, top = d.gap / 2)
            )
        }
    }
}
