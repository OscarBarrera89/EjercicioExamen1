package com.OscarBarrera.examenEj1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.OscarBarrera.examenEj1.model.reposirotyVideojuego.getVideojuegos
import com.OscarBarrera.examenEj1.ui.theme.ExamenEj1Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenEj1Theme {
                ListaVideojuegos()
            }
        }
    }
}

/*
Crear una pantalla que muestre una lista de videojuegos, cada uno con una imagen,
un nombre y un precio.
 */
@Preview
@Composable
fun ListaVideojuegos() {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(20.dp).background(Color.White)) {
        getVideojuegos().forEach { videojuego ->
            item {
                AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                    .data(videojuego.imageUrl)
                    .transformations(CircleCropTransformation())
                    .crossfade(2000)
                    .build(),contentDescription = videojuego.name)
                Text(text = videojuego.name, color= Color.Black, fontSize = 20.sp)
                Text(text = "${videojuego.price} USD", color= Color.Black)
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}
