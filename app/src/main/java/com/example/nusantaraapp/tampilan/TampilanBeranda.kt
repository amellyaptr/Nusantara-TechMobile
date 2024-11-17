package com.example.nusantaraapp.tampilan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nusantaraapp.R
import com.example.nusantaraapp.data.DummyData
import com.example.nusantaraapp.navigation.Screen
import com.example.nusantaraapp.tampilan.component.MakananItem
import com.example.nusantaraapp.tampilan.component.ProvinsiItem
import com.example.nusantaraapp.tipe.Makanan
import com.example.nusantaraapp.tipe.Provinsi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilanBeranda(
    navController: NavController,
    modifier: Modifier = Modifier,
    provinsi: List<Provinsi> = DummyData.provinsiIndonesia,
    makanan: List<Makanan> = DummyData.makananNusantara,
) {
    val searchQuery = remember { mutableStateOf("") }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFFFFFFF), Color(0xFF53808C), Color(0xFFFFFFFF)) // Perbaiki format gradient
                )
            )
    ) {
        // Search Bar
        item {
            TextField(
                value = searchQuery.value,
                onValueChange = { searchQuery.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(85.dp)
                    .padding(16.dp),
                placeholder = { Text(text = "Cari Provinsi...") },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Gray
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "Pencarian",
                        tint = Color.Gray,
                        modifier = Modifier.size(24.dp),
                    )
                }
            )
        }

        item {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Provinsi",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 3.dp),
                    textAlign = TextAlign.Start,
                    color = Color.Black
                )
                //Menampilkan Provinsi
                LazyRow(
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .padding(top = 0.dp)
                ) {
                    items(provinsi, key = { it.id }) { provinsiItem ->
                        val makananItem = makanan.find { it.id == provinsiItem.id }

                        if (makananItem != null) {
                            ProvinsiItem(provinsi = provinsiItem) { provinsiId ->
                                navController.navigate(Screen.DetailProvinsi.route + "/${provinsiId}/${makananItem.id}")
                            }
                        }
                    }
                }
            }
        }

        // Menampilkan Makanan Nusantara dan Daftar Makanan
        item {
            Text(
                text = "Makanan Nusantara",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 0.dp)
                    .padding(16.dp)
                    .padding(bottom = 0.dp),
                textAlign = TextAlign.Start,
                color = Color.Black
            )
        }

        items(makanan, key = { it.id }) { makananItem ->
            MakananItem(makanan = makananItem) { makananId ->
                navController.navigate(Screen.DetailMakanan.route + "/$makananId")
            }
        }
    }
}
