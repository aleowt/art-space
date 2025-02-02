package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp(modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var artwork by remember { mutableIntStateOf(1) }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        when (artwork) {
            1 -> {
                ArtworkWallAndDescriptor(
                    drawableResourceId = R.drawable._52144815_e7ab5ef05c_o,
                    contentDescriptionResourceId = R.string.anzac_bridge_content_description,
                    titleResourceId = R.string.anzac_bridge,
                    artistResourceId = R.string.malcolm_buck,
                    yearResourceId = R.string.anzac_bridge_year
                )
            }
            2 -> {
                ArtworkWallAndDescriptor(
                    drawableResourceId = R.drawable._1744142740_3abeff08e2_c,
                    contentDescriptionResourceId = R.string.terrorism_content_description,
                    titleResourceId = R.string.terrorism,
                    artistResourceId = R.string.dennis_jarvis,
                    yearResourceId = R.string.terrorism_year
                )
            }
            3 -> {
                ArtworkWallAndDescriptor(
                    drawableResourceId = R.drawable._3289859034_fc8bc20d0a_c,
                    contentDescriptionResourceId = R.string.bumblebee_content_description,
                    titleResourceId = R.string.bumblebee,
                    artistResourceId = R.string.james_johnstone,
                    yearResourceId = R.string.bumblebee_year
                )
            }
        }
        Row(
            modifier = modifier.padding(top = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = {
                    artwork--
                    if (artwork == 0) {
                        artwork = 3
                    }
                },
                contentPadding = PaddingValues(horizontal = 40.dp)
            ) {
                Text("Previous")
            }
            Button(onClick = {
                artwork++
                if (artwork == 4) {
                    artwork = 1
                }
            },
                contentPadding = PaddingValues(horizontal = 52.dp)
            ) {
                Text("Next")
            }
        }
    }
}

@Composable
fun ArtworkWallAndDescriptor(
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    titleResourceId: Int,
    artistResourceId: Int,
    yearResourceId: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .padding(bottom = 44.dp)
            .border(32.dp, Color.White),
        shadowElevation = 8.dp,
    ) {
        Image(
            painter = painterResource(drawableResourceId),
            contentDescription = stringResource(contentDescriptionResourceId)
        )
    }
    Surface(
        modifier = modifier.padding(16.dp),
        color = MaterialTheme.colorScheme.inverseOnSurface
    ) {
        Column(modifier = modifier.padding(12.dp)) {
            Text(
                text = stringResource(titleResourceId),
                fontSize = 30.sp,
                fontWeight = FontWeight.Light
            )
            Row {
                Text(
                    text = stringResource(artistResourceId),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = modifier.size(4.dp))
                Text(
                    text = stringResource(yearResourceId),
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceLayoutPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}