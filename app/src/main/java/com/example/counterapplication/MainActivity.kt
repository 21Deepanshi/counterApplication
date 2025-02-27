package com.example.counterapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import com.example.counterapplication.ui.theme.CounterApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CounterApp(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color.Red, Color.Yellow, Color.Green)
                    ),
                )
                .padding(20.dp)
                .width(130.dp)
                .height(150.dp)

        ) {
            // Counter Text with Styling
            Text(
                text = "$count",
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                modifier = Modifier.align(Alignment.Center) // Center the text inside the Box
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        // Row for the buttons
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Plus Button
            Button(
                onClick = {
                    count++
                },
                colors = ButtonDefaults.buttonColors(Color(0xFFD3D3D3)),
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "+", color = Color.Black, fontSize = 24.sp)
            }

            Spacer(modifier = Modifier.width(30.dp))

            // Minus Button
            Button(
                onClick = {
                    if (count > 0) count--
                },
                colors = ButtonDefaults.buttonColors(Color(0xFFD3D3D3)),
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "-",color = Color.Black, fontSize = 24.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CounterApplicationTheme {
        CounterApp()
    }
}
