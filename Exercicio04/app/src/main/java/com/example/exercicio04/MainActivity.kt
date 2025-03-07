@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.loginui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Ícone e Título
        Icon(
            painter = painterResource(id = android.R.drawable.ic_dialog_email),
            contentDescription = "Logo",
            modifier = Modifier
                .size(80.dp)
                .padding(bottom = 8.dp),
            tint = Color.Green
        )
        Text(
            text = "Chatt",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Green
        )
        Text(
            text = "Simple mobile chat and notes.",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SocialButton("Sign in with Facebook", Color(0xFF3b5998), Modifier.weight(1f))
            SocialButton("Sign in with Twitter", Color(0xFF1DA1F2), Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("or", fontSize = 16.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))


        CustomTextField(email, "Email", Icons.Default.Email) { email = it }
        CustomTextField(password, "Password", Icons.Default.Lock, isPassword = true) { password = it }

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Register", fontSize = 18.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Log in",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E88E5),
            modifier = Modifier.clickable {  }
        )
        Text(
            text = "I've forgotten my password?",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun SocialButton(text: String, backgroundColor: Color, modifier: Modifier) {
    Button(
        onClick = { /* Implementar login social */ },
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text, fontSize = 14.sp, color = Color.White, textAlign = TextAlign.Center)
    }
}

@Composable
fun CustomTextField(value: String, placeholder: String, icon: androidx.compose.ui.graphics.vector.ImageVector, isPassword: Boolean = false, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder) },
        leadingIcon = { Icon(imageVector = icon, contentDescription = null) },
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    )
}
