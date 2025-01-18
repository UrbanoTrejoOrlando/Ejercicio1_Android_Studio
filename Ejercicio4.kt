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

class ValidarClave : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValidarClaveScreen()
        }
    }
}

@Composable
fun ValidarClaveScreen() {
    val claveCorrecta = "tesji123"
    var clave by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf<String?>(null) }

    Column {
        OutlinedTextField(
            value = clave,
            onValueChange = { clave = it },
            label = { Text("Ingrese la clave") }
        )
        Button(onClick = {
            mensaje = if (clave == claveCorrecta) "Clave correcta. Puede ingresar." else "Clave incorrecta. Verifique los datos."
        }) {
            Text("Validar Clave")
        }
        mensaje?.let {
            Text(text = it)
        }
    }
}
