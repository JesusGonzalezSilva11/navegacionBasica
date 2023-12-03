package com.example.sergionavegacion.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun Pantalla2(modifier: Modifier) {

    Column(
        modifier=modifier
    ) {
        Text(text = "Soy pantalla2")
        Button(onClick = { }
        ) {
            Text(text = "No hago nada")
        }
    }
}
