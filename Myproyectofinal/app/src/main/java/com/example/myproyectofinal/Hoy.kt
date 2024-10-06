package com.example.myproyectofinal

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color


@Composable
fun hoy(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(25.dp)) {

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            encabezado()
        }
        Column(modifier = Modifier.padding(vertical = 40.dp,horizontal = 20.dp)) {
            Text("Hoy", fontSize = 30.sp, color = Color.Red)
        }
        agregar_nueva(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }

}
@Composable
fun encabezado(){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()){

        Row(verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)){
            Row(verticalAlignment = Alignment.CenterVertically){

                Image(
                    painter = painterResource(id = R.drawable.left_arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .size(15.dp)
                        .padding(end = 3.dp)
                )
                Text("Listas", fontSize = 20.sp)
            }
            Image(
                painter = painterResource(id = R.drawable.menu_rojo),
                contentDescription = null,
                modifier = Modifier.size(26.dp)
            )

        }


    }
}
@Composable
fun agregar_nueva(modifier: Modifier){

        Row(verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)){

            Image(
                painter = painterResource(id = R.drawable.add_rojo),
                contentDescription = null,
                modifier = Modifier
                    .size(26.dp)
                    .padding(end = 3.dp)
            )
            Text("Nuevo", fontSize = 20.sp)

        }

}
@Composable
fun hoyScreenPreview() {
    hoy()
}