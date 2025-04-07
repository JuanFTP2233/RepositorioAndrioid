package com.example.menus

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ScreamB(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pantalla B - Datos guardados")

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(datosGuardados) { dato ->
                Text("• $dato", modifier = Modifier.padding(4.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("screamA") }) {
            Text(text = "Volver a Pantalla A")
        }

        Button(onClick = { navController.navigate("screamC") }) {
            Text(text = "Ir a Pantalla C")
        }
    }
}
