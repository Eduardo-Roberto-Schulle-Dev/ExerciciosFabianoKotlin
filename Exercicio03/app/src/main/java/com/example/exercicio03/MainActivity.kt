@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.exercicio03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CategoriesScreen()
            }
        }
    }
}

@Composable
fun CategoriesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF78909C))
    ) {
        TopAppBar(
            title = { Text("Categories", color = Color.White, fontSize = 20.sp) },
            navigationIcon = {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                    contentDescription = "Menu",
                    tint = Color.White,
                    modifier = Modifier.padding(16.dp)
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF607D8B))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            GridRow("Woman", "Man", Modifier.weight(1f))
            GridRow("Baby", "Travel", Modifier.weight(1f))
            GridRow("Tech", "Food&Drink", Modifier.weight(1f))
        }
    }
}

@Composable
fun GridRow(label1: String, label2: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        CategoryItem(label1, Modifier.weight(1f))
        CategoryItem(label2, Modifier.weight(1f))
    }
}

@Composable
fun CategoryItem(label: String, modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(4.dp)
            .background(Color(0xFF546E7A), shape = RoundedCornerShape(8.dp))
            .clickable {  },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
