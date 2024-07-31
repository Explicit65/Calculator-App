package com.example.nativeandroidcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nativeandroidcalculator.ui.theme.NativeAndroidCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NativeAndroidCalculatorTheme {
                Surface (
                    modifier = Modifier.fillMaxSize()
                ) {
                    NativeAndroidCalculator()
                }
            }
        }
    }
}

@Composable
fun NativeAndroidCalculator() {
    Column (
        modifier = Modifier.padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row (modifier = Modifier
            .weight(1f)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            CalculatorButton(text = stringResource(R.string.C))
            CalculatorButton(text = stringResource(R.string.bracket_sign))
            CalculatorButton(text = stringResource(R.string.percentage_sign))
            CalculatorButton(text = stringResource(R.string.division))
        }
        Row (modifier = Modifier
            .weight(1f)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            CalculatorButton(text = stringResource(R.string.no_7))
            CalculatorButton(text = stringResource(R.string.no_8))
            CalculatorButton(text = stringResource(R.string.no_9))
            CalculatorButton(text = stringResource(R.string.no_x))
        }
        Row (modifier = Modifier
            .weight(1f)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            CalculatorButton(text = stringResource(R.string.no_4))
            CalculatorButton(text = stringResource(R.string.no_5))
            CalculatorButton(text = stringResource(R.string.no_6))
            CalculatorButton(text = stringResource(R.string.substraction))
        }
        Row (modifier = Modifier
            .weight(1f)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            CalculatorButton(text = stringResource(R.string.no_1))
            CalculatorButton(text = stringResource(R.string.no_2))
            CalculatorButton(text = stringResource(R.string.no_3))
            CalculatorButton(text = stringResource(R.string.addition))
        }
        Row (modifier = Modifier
            .weight(1f)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            CalculatorButton(text = stringResource(R.string.addition_substraction))
            CalculatorButton(text = stringResource(R.string.no_0))
            CalculatorButton(text = stringResource(R.string.fullstop))
            CalculatorButton(text = stringResource(R.string.equal_to))
        }
    }
}

@Composable
fun CalculatorButton (text: String) {
    val lighterGray = Color(0xFFD3D3D3)
    Button(
        onClick = { /*TODO*/ },
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = lighterGray),
        modifier = Modifier.size(70.dp)
    ) {
        Text(text = text,
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    NativeAndroidCalculatorTheme {
//        Greeting("Android")
//    }
//}