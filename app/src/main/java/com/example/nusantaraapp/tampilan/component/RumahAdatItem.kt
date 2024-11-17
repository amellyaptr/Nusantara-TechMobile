package com.example.nusantaraapp.tampilan.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nusantaraapp.R
import com.example.nusantaraapp.tipe.RumahAdat
import com.example.nusantaraapp.ui.theme.NusantaraAppTheme

@Composable
fun RumahAdatItem(
    rumahAdat: RumahAdat,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onItemClicked(rumahAdat.id) // Navigasi berdasarkan ID rumah adat
            }
    ) {
        Image(
            painter = painterResource(id = rumahAdat.imageRes),
            contentDescription = rumahAdat.province,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = rumahAdat.province,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun RumahAdatItemPreview() {
    NusantaraAppTheme {
        RumahAdatItem(
            rumahAdat = RumahAdat(
                1,
                "Lampung",
                "",
                R.drawable.nuwousesat
            ),
            onItemClicked = { rumahAdatId ->
                println("RumahAdat Id : $rumahAdatId")
            }
        )
    }
}