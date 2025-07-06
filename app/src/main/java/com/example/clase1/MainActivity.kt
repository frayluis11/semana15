package com.example.clase1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clase1.ui.theme.CLASE1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CLASE1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CarruselPantallaCompleta(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CarruselPantallaCompleta(modifier: Modifier = Modifier) {
    val imagenes = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4
    )

    var indiceActual by remember { mutableStateOf(0) }

    Box(modifier = modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = imagenes[indiceActual]),
            contentDescription = "Imagen carrusel",
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.Black.copy(alpha = 0.4f))
                .align(Alignment.TopCenter)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { if (indiceActual > 0) indiceActual-- },
                enabled = indiceActual > 0,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black.copy(alpha = 0.6f))
            ) {
                Text(text = "Atrás", color = Color.White)
            }

            Button(
                onClick = { if (indiceActual < imagenes.size - 1) indiceActual++ },
                enabled = indiceActual < imagenes.size - 1,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black.copy(alpha = 0.6f))
            ) {
                Text(text = "Siguiente", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CarruselPantallaCompletaPreview() {
    CLASE1Theme {
        CarruselPantallaCompleta()
    }
}
