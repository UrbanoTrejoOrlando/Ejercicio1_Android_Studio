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

class CalculoSueldo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculoSueldoScreen()
        }
    }
}

@Composable
fun CalculoSueldoScreen() {
    var diasTrabajados by remember { mutableStateOf("") }
    var pagoPorHora by remember { mutableStateOf("") }
    var pagoHoraExtra by remember { mutableStateOf("") }
    var horasExtras by remember { mutableStateOf("") }
    var sueldoTotal by remember { mutableStateOf<String?>(null) }

    Column {
        OutlinedTextField(
            value = diasTrabajados,
            onValueChange = { diasTrabajados = it },
            label = { Text("Días trabajados") }
        )
        OutlinedTextField(
            value = pagoPorHora,
            onValueChange = { pagoPorHora = it },
            label = { Text("Pago por hora") }
        )
        OutlinedTextField(
            value = pagoHoraExtra,
            onValueChange = { pagoHoraExtra = it },
            label = { Text("Pago por hora extra") }
        )
        OutlinedTextField(
            value = horasExtras,
            onValueChange = { horasExtras = it },
            label = { Text("Horas extras trabajadas") }
        )
        Button(onClick = {
            val dias = diasTrabajados.toIntOrNull()
            val pagoHora = pagoPorHora.toDoubleOrNull()
            val pagoExtra = pagoHoraExtra.toDoubleOrNull()
            val extras = horasExtras.toIntOrNull()

            sueldoTotal = if (dias != null && pagoHora != null && pagoExtra != null && extras != null) {
                if (extras <= 5) {
                    val sueldoBase = dias * 8 * pagoHora
                    val sueldoExtras = extras * pagoExtra
                    "Sueldo Total: \$${sueldoBase + sueldoExtras}"
                } else {
                    "No se permiten más de 5 horas extras por semana."
                }
            } else {
                "Entrada inválida. Verifique los datos."
            }
        }) {
            Text("Calcular Sueldo")
        }
        sueldoTotal?.let {
            Text(text = it)
        }
    }
}
