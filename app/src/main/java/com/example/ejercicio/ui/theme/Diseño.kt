package com.example.ejercicio.ui.theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.GenericFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Diseño() {
    var texto by remember { mutableStateOf("Hola") }
    val opcionesColores = mapOf(
        "Blanco" to Color.White,
        "Negro" to Color.Black,
        "Azul" to Color.Blue,
        "Rojo" to Color.Red,
        "Verde" to Color.Green
    )
    val opcionesFuentes = mapOf(
        "Times New Roman" to FontFamily.Serif,
        "Sans" to FontFamily.SansSerif,
        "Calibri" to FontFamily.Default,
        "Bell MT" to FontFamily.Cursive,
        "Arial" to FontFamily.SansSerif
    )

    var colorSeleccionado by remember { mutableStateOf(Color.Black) }
    var fuenteSeleccionada by remember { mutableStateOf(FontFamily.SansSerif) }
    var tempColor by remember { mutableStateOf(Color.Black) }
    var tempFuente by remember { mutableStateOf(FontFamily.SansSerif) }
    var expandedColor by remember { mutableStateOf(false) }
    var expandedFuente by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = texto,
            onValueChange = { texto = it },
            label = { Text("Escribe algo") },
            modifier = Modifier.fillMaxWidth()
        )

        ExposedDropdownMenuBox(
            expanded = expandedColor,
            onExpandedChange = { expandedColor = !expandedColor }
        ) {
            OutlinedTextField(
                value = opcionesColores.entries.find { it.value == tempColor }?.key ?: "",
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Seleccionar color")
                },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expandedColor,
                onDismissRequest = { expandedColor = false }
            ) {
                opcionesColores.forEach { (nombre, color) ->
                    DropdownMenuItem(
                        text = { Text(nombre) },
                        onClick = {
                            tempColor = color
                            expandedColor = false
                        }
                    )
                }
            }
        }

        ExposedDropdownMenuBox(
            expanded = expandedFuente,
            onExpandedChange = { expandedFuente = !expandedFuente }
        ) {
            OutlinedTextField(
                value = opcionesFuentes.entries.find { it.value == tempFuente }?.key ?: "",
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Seleccionar fuente")
                },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expandedFuente,
                onDismissRequest = { expandedFuente = false }
            ) {
                opcionesFuentes.forEach { (nombre, fuente) ->
                    DropdownMenuItem(
                        text = { Text(nombre) },
                        onClick = {
                            tempFuente = fuente as GenericFontFamily
                            expandedFuente = false
                        }
                    )
                }
            }
        }

        Text(
            text = texto,
            fontSize = 24.sp,
            fontFamily = fuenteSeleccionada,
            color = colorSeleccionado,
            modifier = Modifier.background(Color.LightGray).padding(8.dp)
        )

        Button(onClick = {
            colorSeleccionado = tempColor
            fuenteSeleccionada = tempFuente
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Aplicar")
        }

        Button(onClick = { texto = "" }, modifier = Modifier.fillMaxWidth()) {
            Text("Limpiar")
        }
    }
}
