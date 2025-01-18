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

class CalculoIMC : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculoIMCScreen()
        }
    }
}

@Composable
fun CalculoIMCScreen() {
    var peso by remember { mutableStateOf("") }
    var estatura by remember { mutableStateOf("") }
    var imc by remember { mutableStateOf<String?>(null) }

    Column {
        OutlinedTextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Peso en kg") }
        )
        OutlinedTextField(
            value = estatura,
            onValueChange = { estatura = it },
            label = { Text("Estatura en m") }
        )
        Button(onClick = {
            val pesoNum = peso.toDoubleOrNull()
            val estaturaNum = estatura.toDoubleOrNull()
            imc = if (pesoNum != null && estaturaNum != null && estaturaNum > 0) {
                (pesoNum / (estaturaNum * estaturaNum)).toString()
            } else {
                "Entrada inválida"
            }
        }) {
            Text("Calcular IMC")
        }
        imc?.let {
            Text(text = "IMC: $it")
        }
    }
}
