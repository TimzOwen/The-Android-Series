package com.timzowen.theandroidseries

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.timzowen.theandroidseries.model.Hero
import com.timzowen.theandroidseries.model.HeroesRepository

@Composable
fun HeroesApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { HeroesAppBar() },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            modifier
                .padding(16.dp)
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(HeroesRepository.heroes) {
                HeroesCardComponent(it)
            }
        }
    }
}

@Composable
fun HeroesCardComponent(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
    ) {
        Row(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Image(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .size(72.dp),
                painter = painterResource(hero.imageRes),
                contentDescription = stringResource(hero.nameRes)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HeroesCardPreview(modifier: Modifier = Modifier) {
    HeroesCardComponent(
        Hero(
            imageRes = R.drawable.android_superhero1,
            descriptionRes = R.string.description1,
            nameRes = R.string.hero1

        )
    )
}