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

class SuperficieCuadrado : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperficieCuadradoScreen()
        }
    }
}

@Composable
fun SuperficieCuadradoScreen() {
    var lado by remember { mutableStateOf("") }
    var superficie by remember { mutableStateOf<String?>(null) }

    Column {
        OutlinedTextField(
            value = lado,
            onValueChange = { lado = it },
            label = { Text("Lado del cuadrado") }
        )
        Button(onClick = {
            val ladoNum = lado.toDoubleOrNull()
            superficie = ladoNum?.let { (it * it).toString() } ?: "Entrada inválida"
        }) {
            Text("Calcular Superficie")
        }
        superficie?.let {
            Text(text = "Superficie: $it")
        }
    }
}
