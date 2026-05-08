package com.timzowen.theandroidseries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.timzowen.theandroidseries.data.DataSource
import com.timzowen.theandroidseries.grid.Course
import com.timzowen.theandroidseries.ui.theme.TheAndroidSeriesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheAndroidSeriesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GridApp(
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GridApp(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        columns = GridCells.Fixed(2)
    ) {
        items(DataSource.topics) { course ->
            GridComponent(course = course)
        }
    }
}

@Composable
fun GridComponent(
    course: Course,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier.height(68.dp),
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFFC8C3D3)
    ) {
        Row(modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp))
                    .size(68.dp)
                    .aspectRatio(1f),
                painter = painterResource(course.imageResourceId),
                contentDescription = stringResource(course.titleResourceId),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(course.titleResourceId),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier.padding(end = 8.dp),
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = "grain"
                    )
                    Text(
                        text = course.courseNumber.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GridAppPreview() {
    TheAndroidSeriesTheme {
        GridComponent(
            Course(
                R.string.film,
                123,
                R.drawable.film
            )
        )

    }
}