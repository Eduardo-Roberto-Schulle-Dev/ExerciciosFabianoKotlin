package com.example.exercicio01

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.LocalTime

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskForm()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskForm() {
    var title by remember { mutableStateOf("") }
    var isDone by remember { mutableStateOf(false) }
    var priority by remember { mutableStateOf("Medium") }
    var date by remember { mutableStateOf(LocalDate.now().toString()) }
    var time by remember { mutableStateOf(LocalTime.now().toString()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.Black), // Fundo escuro como na imagem
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Title", fontSize = 18.sp, color = Color.White)
        BasicTextField(
            value = title,
            onValueChange = { title = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.Gray) // Cor da caixa de texto
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text("Status", fontSize = 18.sp, color = Color.White)
        Row {
            RadioButton(selected = isDone, onClick = { isDone = true })
            Text("Done", color = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            RadioButton(selected = !isDone, onClick = { isDone = false })
            Text("Not Done", color = Color.White)
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text("Priority", fontSize = 18.sp, color = Color.White)
        Row {
            listOf("Low", "Medium", "High").forEach { level ->
                Row {
                    RadioButton(selected = priority == level, onClick = { priority = level })
                    Text(level, color = Color.White)
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text("Time and Date", fontSize = 18.sp, color = Color.White)
        Row {
            Button(onClick = { date = LocalDate.now().toString() }) {
                Text("Choose Date")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { time = LocalTime.now().toString() }) {
                Text("Choose Time")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = { /* Cancel Logic */ }) { Text("Cancel") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { /* Reset Logic */ }) { Text("Reset") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { /* Submit Logic */ }) { Text("Submit") }
        }
    }
}
