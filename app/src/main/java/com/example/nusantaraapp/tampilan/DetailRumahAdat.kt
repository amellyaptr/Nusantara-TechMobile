package com.example.nusantaraapp.tampilan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nusantaraapp.data.DummyData

@Composable
fun DetailRumahAdat(rumahAdatId: String) {
    val rumahAdatId = rumahAdatId.toIntOrNull() ?: return // Convert string ke int dan pastikan ID valid
    val rumahAdat = DummyData.rumahNusantara.find { it.id == rumahAdatId }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFFFFFFF), Color(0xFF53808C))
                )
            )
    ) {
        if (rumahAdat != null) {
            Column(modifier = Modifier.padding(16.dp)) {

                // Teks "Rumah Adat" di luar Card
                Text(
                    text = "Rumah Adat ${rumahAdat.province}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    textAlign = TextAlign.Center
                )

                // Spacer untuk menambah jarak antara teks dan gambar
                Spacer(modifier = Modifier.height(13.dp))

                // Card utama
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp) // Menambahkan padding dalam card utama
                    ) {
                        // Gambar berada di dalam Card
                        Image(
                            painter = painterResource(id = rumahAdat.imageRes),
                            contentDescription = "Image of ${rumahAdat.name}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp) // Sesuaikan tinggi gambar
                        )

                        // Mengurangi jarak antara gambar dan card deskripsi
                        Spacer(modifier = Modifier.height(2.dp))

                        // Card di dalam Card untuk teks deskripsi
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFF5F5F5)
                            ),
                            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
                        ) {
                            // Teks deskripsi
                            Text(
                                text = "Provinsi ${rumahAdat.province} memiliki Rumah Adat daerah yang diberi nama ${rumahAdat.name}.",
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                textAlign = TextAlign.Justify
                            )
                        }
                    }
                }
            }
        } else {
            Text(
                "Rumah adat tidak ditemukan",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailRumahAdatPreview() {
    // Preview dengan rumahId yang sudah diberikan
    DetailRumahAdat(rumahAdatId = "1")
}