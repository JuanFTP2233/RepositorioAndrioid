package com.example.menus

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.mutableStateListOf

val datosGuardados = mutableStateListOf<String>()

@Composable
fun ScreamA(navController: NavController) {
    var texto by remember { mutableStateOf("") }




    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pantalla A")

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = texto,
            onValueChange = { texto = it },
            label = { Text("Ingresa un dato") }
        )

        TextField(
            value = texto,
            onValueChange = { texto = it },
            label = { Text("Ingresa un dato") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (texto.isNotBlank()) {
                datosGuardados.add(texto)
                texto = ""
            }
        }) {
            Text(text = "Guardar dato")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("screamB") }) {
            Text(text = "Ir a Pantalla B")
        }

        Button(onClick = { navController.navigate("screamC") }) {
            Text(text = "Ir a Pantalla C")
        }
    }
}
