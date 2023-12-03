package com.example.sergionavegacion.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun Pantalla3(modifier: Modifier, buttonPantalla4: () -> Unit) {

    Column(
        modifier=modifier
    ) {
        Text(text = "Soy pantalla3")
        Button(onClick = buttonPantalla4
        ) {
            Text(text = "Te llevo a pantalla 4")
        }
    }
}