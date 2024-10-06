package com.example.myproyectofinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.Menu
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myproyectofinal.ui.theme.MyProyectoFinalTheme
import kotlinx.coroutines.delay
import com.example.myproyectofinal.menu

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyProyectoFinalTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "first_screen") {
                    composable("first_screen") {
                        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                            Box(modifier = Modifier.fillMaxSize()) {
                                Image(
                                    painter = painterResource(id = R.drawable.fondo),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp)
                                ) {
                                    Text(
                                        text = "NoteTasker",
                                        fontSize = 36.sp,
                                        fontFamily = FontFamily.SansSerif,
                                        modifier = Modifier
                                            .align(Alignment.Center)
                                            .offset(y = (-250).dp)
                                    )
                                }
                                Image(
                                    painter = painterResource(id = R.drawable.work_order),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .size(200.dp)
                                )
                                Greeting(
                                    modifier = Modifier.padding(innerPadding)
                                )
                                LaunchedEffect(Unit) {
                                    delay(3000)
                                    navController.navigate("menu") {
                                        popUpTo("first_screen") { inclusive = true }
                                    }
                                }
                            }
                        }

                    }
                    composable("menu") {
                        menu(navController)
                    }
                    composable("Hoy") {
                        hoy()
                    }
                    composable("Programadas") {

                    }
                    composable("Todos") {

                    }
                    composable("Terminados") {

                    }
                }
            }
                }
        }
    }


@Composable
fun Greeting(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyProyectoFinalTheme {
        Greeting()
    }
}