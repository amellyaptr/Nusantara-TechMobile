package com.example.nusantaraapp.tampilan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun DetailProvinsi(makananId: String, rumahAdatId: String) {
    val makananId = makananId.toIntOrNull() ?: return
    val makanan = DummyData.makananNusantara.find { it.id == makananId }
    val rumahAdatId = rumahAdatId.toIntOrNull() ?: return
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
        if (makanan != null && rumahAdat != null) {
            Column(modifier = Modifier.padding(16.dp)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Provinsi ${makanan.province}",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        textAlign = TextAlign.Center
                    )
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = makanan.imageRes),
                                contentDescription = "Image of ${makanan.name}",
                                modifier = Modifier
                                    .size(160.dp)
                                    .aspectRatio(1f)
                                    .padding(8.dp)
                            )
                            Image(
                                painter = painterResource(id = rumahAdat.imageRes),
                                contentDescription = "Image of ${rumahAdat.name}",
                                modifier = Modifier
                                    .size(160.dp)
                                    .aspectRatio(1f)
                                    .padding(8.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Card(
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFF5F5F5)
                            ),
                            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
                        ) {
                            Column(modifier = Modifier.padding(8.dp)) {
                                Text(
                                    text = "Setiap Provinsi memiliki ciri khas daerahnya. Provinsi ${rumahAdat.province}, " +
                                            "memiliki ciri khas dari makanan yaitu ${makanan.name} " +
                                            "dan terdapat Rumah Adat bernama ${rumahAdat.name}.",
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.Black,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(13.dp),
                                    textAlign = TextAlign.Justify
                                )
                            }
                        }
                    }
                }
            }
        } else {
            Text("Budaya atau Makanan tidak ditemukan")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailProvinsiPreview() {
    DetailProvinsi(makananId = "1", rumahAdatId = "1")
}