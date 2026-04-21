package com.timzowen.theandroidseries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.timzowen.theandroidseries.ui.theme.TheAndroidSeriesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheAndroidSeriesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuadrantApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun QuadrantApp(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Row(modifier = Modifier.weight(1f)) {
            QuadrantComponent(
                modifier = Modifier.weight(1f),
                title = stringResource(R.string.text_composable),
                description = stringResource(R.string.text_composable_description),
                backgroundColor = Color(0xFFEADDFF)
            )
            QuadrantComponent(
                modifier = Modifier.weight(1f),
                title = stringResource(R.string.image_composable),
                description = stringResource(R.string.image_composable_desc),
                backgroundColor = Color(0xFFD0BCFF)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            QuadrantComponent(
                modifier = Modifier.weight(1f),
                title = stringResource(R.string.row_composable),
                description = stringResource(R.string.row_composable_description),
                backgroundColor = Color(0xFFB69DF8)
            )
            QuadrantComponent(
                modifier = Modifier.weight(1f),
                title = stringResource(R.string.column_composable),
                description = stringResource(R.string.column_composable_description),
                backgroundColor = Color(0xFFF6EDFF)
            )
        }
    }
}

@Composable
fun QuadrantComponent(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TheAndroidSeriesTheme {
        QuadrantApp()
    }
}