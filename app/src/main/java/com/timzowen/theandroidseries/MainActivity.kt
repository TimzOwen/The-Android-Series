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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.timzowen.theandroidseries.model.QuadrantInfo
import com.timzowen.theandroidseries.ui.theme.Quadrant1Color
import com.timzowen.theandroidseries.ui.theme.Quadrant2Color
import com.timzowen.theandroidseries.ui.theme.Quadrant3Color
import com.timzowen.theandroidseries.ui.theme.Quadrant4Color
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
    val quadrants = listOf(
        QuadrantInfo(
            title = stringResource(R.string.text_composable),
            description = stringResource(R.string.text_composable_description),
            backgroundColor = Quadrant1Color
        ),
        QuadrantInfo(
            title = stringResource(R.string.image_composable),
            description = stringResource(R.string.image_composable_desc),
            backgroundColor = Quadrant2Color
        ),
        QuadrantInfo(
            title = stringResource(R.string.row_composable),
            description = stringResource(R.string.row_composable_description),
            backgroundColor = Quadrant3Color
        ),
        QuadrantInfo(
            title = stringResource(R.string.column_composable),
            description = stringResource(R.string.column_composable_description),
            backgroundColor = Quadrant4Color
        )
    )

    Column(modifier = modifier.fillMaxSize()) {
        Row(modifier = Modifier.weight(1f)) {
            QuadrantComponent(
                info = quadrants[0],
                modifier = Modifier.weight(1f)
            )
            QuadrantComponent(
                info = quadrants[1],
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            QuadrantComponent(
                info = quadrants[2],
                modifier = Modifier.weight(1f)
            )
            QuadrantComponent(
                info = quadrants[3],
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun QuadrantComponent(
    info: QuadrantInfo,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(info.backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = info.title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = info.description,
            textAlign = TextAlign.Justify
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