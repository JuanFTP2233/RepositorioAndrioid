package com.example.menus

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ScreamC(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pantalla C")
        Button(onClick = { navController.navigate("screamA") }) {
            Text(text = "Volver a Pantalla A")
        }
        Button(onClick = { navController.navigate("screamB") }) {
            Text(text = "Ir a Pantalla B")
        }
    }
}
