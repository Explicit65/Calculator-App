package com.example.nativeandroidcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.objecthunter.exp4j.ExpressionBuilder
import com.example.nativeandroidcalculator.ui.theme.NativeAndroidCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NativeAndroidCalculatorTheme {
                Surface(
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
    val DarkGreen = Color(0xFF006400)
    val DividerColor = Color(0xFFD3D3D3)
    val inputState = remember { mutableStateOf("") }
    val isPlusState = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = inputState.value,
                fontSize = 24.sp,
                color = DividerColor,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        Row(
            modifier = Modifier
                .padding(bottom = 30.dp, start = 20.dp, end = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            IconButton(iconResId = R.drawable.clock_icon)
            IconButton(iconResId = R.drawable.metric_icon)
            IconButton(iconResId = R.drawable.orientation_icon)
            Spacer(modifier = Modifier.weight(1f))
            IconButton(iconResId = R.drawable.backspace_icon)
        }
        Divider(color = DividerColor, thickness = 1.dp, modifier = Modifier.padding(bottom = 16.dp))
        Row(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CalculatorButton(text = stringResource(R.string.C), textColor = Color.Red) {
                inputState.value = ""
            }
            CalculatorButton(text = stringResource(R.string.bracket_sign), textColor = DarkGreen) {
                inputState.value += "("
            }
            CalculatorButton(text = stringResource(R.string.percentage_sign), textColor = DarkGreen) {
                inputState.value += "%"
            }
            CalculatorButton(text = stringResource(R.string.division), textColor = DarkGreen) {
                inputState.value += "/"
            }
        }
        Row(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CalculatorButton(text = stringResource(R.string.no_7)) {
                inputState.value += "7"
            }
            CalculatorButton(text = stringResource(R.string.no_8)) {
                inputState.value += "8"
            }
            CalculatorButton(text = stringResource(R.string.no_9)) {
                inputState.value += "9"
            }
            CalculatorButton(text = stringResource(R.string.no_x), textColor = DarkGreen) {
                inputState.value += "*"
            }
        }
        Row(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CalculatorButton(text = stringResource(R.string.no_4)) {
                inputState.value += "4"
            }
            CalculatorButton(text = stringResource(R.string.no_5)) {
                inputState.value += "5"
            }
            CalculatorButton(text = stringResource(R.string.no_6)) {
                inputState.value += "6"
            }
            CalculatorButton(text = stringResource(R.string.substraction), textColor = DarkGreen) {
                inputState.value += "-"
            }
        }
        Row(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CalculatorButton(text = stringResource(R.string.no_1)) {
                inputState.value += "1"
            }
            CalculatorButton(text = stringResource(R.string.no_2)) {
                inputState.value += "2"
            }
            CalculatorButton(text = stringResource(R.string.no_3)) {
                inputState.value += "3"
            }
            CalculatorButton(text = stringResource(R.string.addition), textColor = DarkGreen) {
                inputState.value += "+"
            }
        }
        Row(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CalculatorButton(text = stringResource(R.string.addition_substraction)) {
                if (isPlusState.value) {
                    inputState.value = "+"
                } else {
                    inputState.value = "-"
                }
                isPlusState.value = !isPlusState.value
            }
            CalculatorButton(text = stringResource(R.string.no_0)) {
                inputState.value += "0"
            }
            CalculatorButton(text = stringResource(R.string.fullstop)) {
                inputState.value += "."
            }
            CalculatorButton(text = stringResource(R.string.equal_to), textColor = Color.White, buttonColor = DarkGreen) {
                inputState.value = evaluateExpression(inputState.value)
            }
        }
    }
}

@Composable
fun CalculatorButton(
    text: String,
    textColor: Color = Color.Black,
    buttonColor: Color = Color(0xFFF0F0F0),
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        modifier = Modifier.size(75.dp)
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            color = textColor
        )
    }
}

@Composable
fun IconButton(
    iconResId: Int = R.drawable.clock_icon,
) {
    Image(painter = painterResource(id = iconResId), contentDescription = null)
}

fun evaluateExpression(expression: String): String {
    return try {
        val result = ExpressionBuilder(expression).build().evaluate()
        if (result == result.toLong().toDouble()) {
            result.toLong().toString()
        } else {
            result.toString()
        }
    } catch (e: Exception) {
        "Error"
    }
}

@Preview(showBackground = true)
@Composable
fun NativeAndroidCalculatorPreview() {
    NativeAndroidCalculatorTheme {
        NativeAndroidCalculator()
    }
}
