package com.example.compose3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Button

class TotalCompra : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TotalCompraScreen()
        }
    }
}

@Composable
fun TotalCompraScreen() {
    var precio by remember { mutableStateOf("") }
    var cantidad by remember { mutableStateOf("") }
    var total by remember { mutableStateOf<String?>(null) }

    Column {
        OutlinedTextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio del artículo") }
        )
        OutlinedTextField(
            value = cantidad,
            onValueChange = { cantidad = it },
            label = { Text("Cantidad de artículos") }
        )
        Button(onClick = {
            val precioNum = precio.toDoubleOrNull()
            val cantidadNum = cantidad.toIntOrNull()
            total = if (precioNum != null && cantidadNum != null) {
                (precioNum * cantidadNum).toString()
            } else {
                "Entrada inválida"
            }
        }) {
            Text("Calcular Total")
        }
        total?.let {
            Text(text = "Total: $it")
        }
    }
}
