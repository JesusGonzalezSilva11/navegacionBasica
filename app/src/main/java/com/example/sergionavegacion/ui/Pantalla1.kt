package com.example.sergionavegacion.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Pantalla1(modifier: Modifier, buttonPantalla2: () -> Unit, buttonPantalla3: () -> Unit) {

    Column(
        modifier=modifier
    ) {
        Text(text = "Soy pantalla1")
        Button(onClick =
            buttonPantalla2

        ) {
            Text(text = "Te llevo a pantalla 2")
        }
        Button(onClick =  buttonPantalla3
        ) {
            Text(text = "Te llevo a pantalla 3")
        }
    }
}