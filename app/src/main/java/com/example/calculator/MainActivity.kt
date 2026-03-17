package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                CalculatorScreen()
            }
        }
    }
}

@Composable
fun CalculatorScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Display(
            display = "0",
            modifier = Modifier.weight(1f)
        )

        Keyboard()
    }
}

@Composable
fun Display(
    display: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .border(
                width = 2.dp,
                color = Color(0xFF7B1FA2),
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = Color(0xFFEDE7F6),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Text(
            text = display,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Composable
fun Keyboard() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        CalculatorRow(listOf("7", "8", "9", "/"))
        CalculatorRow(listOf("4", "5", "6", "*"))
        CalculatorRow(listOf("1", "2", "3", "-"))
        CalculatorRow(listOf("0", "C", "=", "+"))
    }
}

@Composable
fun CalculatorRow(
    buttons: List<String>
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        buttons.forEach { label ->
            CalculatorButton(label, Modifier.weight(1f))
        }
    }
}

@Composable
fun CalculatorButton(
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { /* aqui seria a lógica */ },
        modifier = modifier.height(70.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF7B1FA2)
        )
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            color = Color.White
        )
    }
}