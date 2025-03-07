package com.example.exercicio6
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share

@Composable
fun BookDetailsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.book_cover),
            contentDescription = "Book Cover",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "The Silkworm", style = MaterialTheme.typography.headlineSmall)
        Text(text = "Robert Galbraith", style = MaterialTheme.typography.bodyMedium)
        Text(text = "June 19, 2014", style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { /* Lógica para ler mais */ }) {
            Text(text = "READ MORE")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "4.0", style = MaterialTheme.typography.headlineSmall)
                Text(text = "757 A", style = MaterialTheme.typography.bodySmall)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Filled.Search, contentDescription = "Search")
                Text(text = "Mystery & Thrillers", style = MaterialTheme.typography.bodySmall)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Filled.Share, contentDescription = "Share")
                Text(text = "Similar", style = MaterialTheme.typography.bodySmall)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Private Investigator Cormoran Strike returns in a new mystery from Robert Galbraith, author of the #1 international bestseller The Cuckoo's Calling.",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BookDetailsScreenPreview() {
    BookDetailsScreen()
}