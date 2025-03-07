package com.example.exercicio7
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid

@Composable
fun BoaViagemHomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "BoaViagem", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                HomeButton(text = "Novo Gasto", icon = R.drawable.ic_novo_gasto)
            }
            item {
                HomeButton(text = "Nova Viagem", icon = R.drawable.ic_nova_viagem)
            }
            item {
                HomeButton(text = "Minhas Viagens", icon = R.drawable.ic_minhas_viagens)
            }
            item {
                HomeButton(text = "Configurações", icon = R.drawable.ic_configuracoes)
            }
        }
    }
}

@Composable
fun HomeButton(text: String, icon: Int) {
    Button(
        onClick = { /* Lógica do botão */ },
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
            Text(text = text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoaViagemHomeScreenPreview() {
    BoaViagemHomeScreen()
}