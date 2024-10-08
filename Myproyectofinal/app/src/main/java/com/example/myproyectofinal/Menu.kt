package com.example.myproyectofinal

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.myproyectofinal.hoy


@Composable
fun menu(navController: NavHostController) {
    val searchText = remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = searchText.value,
            onValueChange = { searchText.value = it },
            label = { Text("Buscar") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Column {
            Row {
                TaskButton(R.drawable.calendar, "Hoy") {
                    navController.navigate("Hoy")
                }
                TaskButton(R.drawable.calendar_azul, "Programadas") {
                    navController.navigate("Programadas")
                }
            }
            Row {
                TaskButton(R.drawable.folder, "Todos") {
                    navController.navigate("Todos")
                }
                TaskButton(R.drawable.yes, "Terminados") {
                    navController.navigate("Terminados")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Mis Listas", style = MaterialTheme.typography.headlineSmall)
        }
        SectionHeader("Mis notas", R.drawable.notes)
        SectionHeader("Tareas", R.drawable.tareas)

    }

}
@Composable
fun TaskButton(iconResId: Int, text: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .size(170.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text)
        }
    }
}
@Composable
fun SectionHeader(title: String, iconResId: Int) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(60.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Text(title, style = MaterialTheme.typography.headlineSmall)
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    val navController = rememberNavController()
    menu(navController)

}
