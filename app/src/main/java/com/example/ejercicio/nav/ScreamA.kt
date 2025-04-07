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
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var cc by remember { mutableStateOf("") }

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
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = cc,
            onValueChange = { cc = it },
            label = { Text("C.C.") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (nombre.isNotBlank() && correo.isNotBlank() && cc.isNotBlank()) {
                val dato = "Nombre: $nombre, Correo: $correo, C.C.: $cc"
                datosGuardados.add(dato)
                nombre = ""
                correo = ""
                cc = ""
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
