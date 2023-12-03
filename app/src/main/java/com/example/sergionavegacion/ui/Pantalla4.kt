package com.example.sergionavegacion.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun Pantalla4(modifier: Modifier) {
    var showDialog by remember  { mutableStateOf(false) }
    var botonDado = remember { mutableStateOf("NO se ha hecho click todavía") }
    Column(
        modifier = modifier
    ) {
        Text(text = "Soy pantalla4")
        Button(onClick = { showDialog = true }
        ) {
            Text(text = "Soy pantalla4")
        }

        val cerrar = { showDialog = false }
        if (showDialog == true) {
            AlertDialogSample(cerrar, botonDado)
        }
        if(botonDado.value != "NO se ha hecho click todavía"){
            Text(text = botonDado.value)
        }
    }
}

@Composable
fun AlertDialogSample(cerrar: () -> Unit, botonDado: MutableState<String>) {
    AlertDialog(
        title = {
            Text(text = "dialogTitle")
        },
        text = {
            Text(text = "dialogText")
        },
        onDismissRequest = {

        },
        confirmButton = {
            TextButton(
                onClick = { cerrar.invoke(); botonDado.value = "Boton dado confirm" }
            ) {
                Text("Confirma y cierra")
            }
        },
        dismissButton = {
            TextButton(
                onClick = { cerrar.invoke(); botonDado.value = "Boton dado dismiss" }
            ) {
                Text("Dismiss y cierra")
            }
        }
    )


}