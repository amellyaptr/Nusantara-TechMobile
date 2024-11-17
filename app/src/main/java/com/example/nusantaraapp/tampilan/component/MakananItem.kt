package com.example.nusantaraapp.tampilan.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nusantaraapp.R
import com.example.nusantaraapp.tipe.Makanan
import com.example.nusantaraapp.ui.theme.NusantaraAppTheme

@Composable
fun MakananItem(
    makanan: Makanan,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClicked(makanan.id) }
            .padding(8.dp)
            .padding(start = 10.dp)
    ) {
        Image(
            painter = painterResource(id = makanan.imageRes),
            contentDescription = makanan.province,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(70.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = makanan.province,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.black)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.detail_button),
            contentDescription = "Arrow to Detail",
            modifier = Modifier
                .size(30.dp)
                .padding(end = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MakananItemPreview() {
    NusantaraAppTheme {
        MakananItem(
            makanan = Makanan(
                1,
                "Lampung",
                "Seruit",
                R.drawable.seruit
            ),
            onItemClicked = { makananId ->
                println("Makanan Id : $makananId")
            }
        )
    }
}