package com.example.nusantaraapp.tampilan.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nusantaraapp.R
import com.example.nusantaraapp.tipe.Provinsi
import com.example.nusantaraapp.ui.theme.NusantaraAppTheme

@Composable
fun ProvinsiItem(
    provinsi: Provinsi,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable {
            onItemClicked(provinsi.id)
        }
    ) {
        Card(
            modifier = Modifier
                .padding(horizontal = 2.dp, vertical = 2.dp)
                .size(80.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = provinsi.imageRes),
                    contentDescription = provinsi.province,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(70.dp)
                )
            }
        }

        Text(
            text = provinsi.province,
            style = MaterialTheme.typography.titleMedium,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier
                .width(80.dp)
                .padding(top = 8.dp),
            maxLines = 1
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProvinsiItemHorizontalPreview() {
    NusantaraAppTheme {
        ProvinsiItem(
            provinsi = Provinsi(
                1,
                "Lampung",
                "Siger",
                R.drawable.siger
            ),
            onItemClicked = { provinsiId ->
                println("Provinsi Id : $provinsiId")
            }
        )
    }
}
