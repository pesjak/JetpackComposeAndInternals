@file:OptIn(ExperimentalMaterialApi::class)

package dev.jorgecastillo.compose.app.ui.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.jorgecastillo.compose.app.R
import dev.jorgecastillo.compose.app.data.FakeSpeakerRepository
import dev.jorgecastillo.compose.app.models.Speaker
import dev.jorgecastillo.compose.app.ui.theme.ComposeAndInternalsTheme

@Composable
fun SpeakersScreen(speakers: List<Speaker>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Speakers") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Default.Add, contentDescription = stringResource(R.string.content_desc_fab_add_speaker))
            }
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding).testTag("SpeakersList")) {
            items(speakers) {
                SpeakerCard(it)
            }
        }
    }
}

@Composable
fun SpeakerCard(speaker: Speaker, onClick: (Speaker) -> Unit = {}) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(dimensionResource(R.dimen.spacing_small)),
        onClick = { onClick(speaker) }) {
        Row(
            modifier = Modifier.padding(dimensionResource(R.dimen.spacing_regular))
        ) {
            Image(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.avatar_size))
                    .clip(CircleShape),
                painter = painterResource(avatarResForId(speaker.id)),
                contentDescription = stringResource(R.string.content_desc_speaker_avatar),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.width(16.dp))
            Column {
                Text(speaker.name, style = MaterialTheme.typography.h6)
                Text(speaker.company, style = MaterialTheme.typography.caption)
            }
        }
    }
}

@SuppressLint("DiscouragedApi")
@Composable
fun avatarResForId(id: String): Int {
    val localContext = LocalContext.current
    return localContext.resources
        .getIdentifier("avatar_$id", "drawable", localContext.packageName)
}

@Composable
@Preview(showBackground = true)
private fun SpeakersScreenPreview() {
    ComposeAndInternalsTheme {
        SpeakersScreen(speakers = FakeSpeakerRepository().getSpeakers())
    }
}
