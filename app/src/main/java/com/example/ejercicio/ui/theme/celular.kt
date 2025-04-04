package com.example.ejercicio.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.text.KeyboardOptions

@Composable
fun Calculadora() {
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    val contexto = LocalContext.current

    fun calcular(n1: String, n2: String, operador: String): String {
        val num1 = n1.toDoubleOrNull()
        val num2 = n2.toDoubleOrNull()
        if (num1 == null || num2 == null) return "ERROR"

        return when (operador) {
            "SUMA" -> (num1 + num2).toString()
            "RESTA" -> (num1 - num2).toString()
            "MULTIPLICACION" -> (num1 * num2).toString()
            "DIVISION" -> if (num2 != 0.0) (num1 / num2).toString() else "ERROR"
            else -> "Operación no válida"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Calculadora", style = MaterialTheme.typography.headlineMedium)

        TextField(
            value = numero1,
            onValueChange = { numero1 = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = numero2,
            onValueChange = { numero2 = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { resultado = calcular(numero1, numero2, "SUMA") }) {
                Text("SUMA")
            }

            Button(onClick = { resultado = calcular(numero1, numero2, "RESTA") }) {
                Text("RESTA")
            }

            Button(onClick = { resultado = calcular(numero1, numero2, "MULTIPLICACION") }) {
                Text("MULTIPLICACION")
            }

            Button(onClick = { resultado = calcular(numero1, numero2, "DIVISION") }) {
                Text("DIVISION")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Resultado: $resultado", style = MaterialTheme.typography.bodyLarge)
    }
}
