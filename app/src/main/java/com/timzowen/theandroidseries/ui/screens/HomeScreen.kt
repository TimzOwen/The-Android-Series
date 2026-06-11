package com.timzowen.theandroidseries.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.timzowen.theandroidseries.R
import com.timzowen.theandroidseries.network.MarsPhoto
import com.timzowen.theandroidseries.ui.theme.TheAndroidSeriesTheme

@Composable
fun HomeScreen(
    marsUiState: MarsUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    when (marsUiState) {
        is MarsUiState.Loading -> LoadingScreen(
            modifier = modifier
                .fillMaxSize()
                .padding(top = contentPadding.calculateTopPadding())
        )

        is MarsUiState.Success -> MarsPhotoCard(
            photo = marsUiState.photos,
            modifier = modifier.fillMaxWidth()
        )

        is MarsUiState.Error -> ErrorScreen(
            modifier = modifier
                .fillMaxSize()
                .padding(top = contentPadding.calculateTopPadding())
        )
    }
}

@Composable
fun MarsPhotoCard(modifier: Modifier = Modifier, photo: MarsPhoto) {
    AsyncImage(
        modifier = modifier.fillMaxWidth(),
        model = ImageRequest.Builder(LocalContext.current)
            .data(photo.imgSrc)
            .crossfade(true)
            .build(),
        contentScale = ContentScale.Crop,
        contentDescription = stringResource(R.string.mars_photo)
    )
}


@Composable
fun ResultScreen(photos: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = photos)
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview() {
    TheAndroidSeriesTheme {
        ResultScreen(stringResource(R.string.placeholder_result))
    }
}
