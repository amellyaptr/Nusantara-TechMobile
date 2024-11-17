package com.example.nusantaraapp.tampilan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusantaraapp.data.DummyData
import com.example.nusantaraapp.navigation.Screen
import com.example.nusantaraapp.tipe.RumahAdat
import com.example.nusantaraapp.ui.theme.CardColor
import com.example.nusantaraapp.ui.theme.NusantaraAppTheme

@Composable
fun TampilanRumahAdat(
    navController: NavController,
    modifier: Modifier = Modifier,
    rumahAdat: List<RumahAdat> = DummyData.rumahNusantara
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp), // Lebar card disesuaikan agar lebih proporsional
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFFFFFFF), Color(0xFF53808C))
                )
            )
    ) {
        items(rumahAdat, key = { it.id }) { rumahAdat ->
            RumahAdatItem(rumahAdat = rumahAdat) { rumahAdatId ->
                navController.navigate(Screen.DetailRumahAdat.route + "/$rumahAdatId")
            }
        }
    }
}

@Composable
fun RumahAdatItem(rumahAdat: RumahAdat, onItemClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(195.dp)
            .clickable { onItemClick(rumahAdat.id) }, // Pindahkan .clickable ke sini
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardColor // Menggunakan warna dari Color.kt
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Menyamakan ukuran gambar dan memastikan gambar memenuhi lebar penuh
            Image(
                painter = painterResource(id = rumahAdat.imageRes),
                contentDescription = rumahAdat.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Text(
                text = rumahAdat.province,
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TampilanRumahAdatPreview() {
    val navController = rememberNavController()
    NusantaraAppTheme {
        TampilanRumahAdat(navController = navController, rumahAdat = DummyData.rumahNusantara)
    }
}