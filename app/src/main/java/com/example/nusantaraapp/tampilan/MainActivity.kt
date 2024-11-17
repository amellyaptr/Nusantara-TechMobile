package com.example.nusantaraapp.tampilan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.compose.ui.Alignment
import com.example.nusantaraapp.R
import com.example.nusantaraapp.navigation.NavigationItem
import com.example.nusantaraapp.navigation.Screen
import com.example.nusantaraapp.ui.theme.CardColor
import com.example.nusantaraapp.ui.theme.NusantaraAppTheme
import com.example.nusantaraapp.ui.theme.Toska
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NusantaraAppTheme {
                    NusantaraApp()
                }
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NusantaraApp() {
    val navController = rememberNavController()
    val selectedItem = remember { mutableStateOf(Screen.Beranda.route) }
    val currentScreenTitle = remember { mutableStateOf("Makanan") }

    val isDetailScreen = remember { mutableStateOf(false) }
    navController.addOnDestinationChangedListener { _, destination, _ ->
        isDetailScreen.value = destination.route in listOf(
            Screen.DetailMakanan.route + "/{makananId}",
            Screen.DetailProvinsi.route + "/{rumahAdatId}/{makananId}",
            Screen.DetailRumahAdat.route + "/{rumahAdatId}"
        )
    }

    val isSplashScreenVisible = remember { mutableStateOf(true) }

    // Fungsi untuk navigasi dari Splash Screen ke Beranda setelah delay
    LaunchedEffect(Unit) {
        delay(3000)  // Delay selama 3 detik
        isSplashScreenVisible.value = false
    }

    // Jika Splash Screen masih aktif, tampilkan SplashScreen
    if (isSplashScreenVisible.value) {
        SplashScreen(navController)
    } else {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = currentScreenTitle.value,
                            color = Color.White
                        )
                    },
                    navigationIcon = {
                        if (isDetailScreen.value) {
                            IconButton(onClick = { navController.navigateUp() }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.back),
                                    contentDescription = "Back",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(23.dp)
                                )
                            }
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Toska,
                        titleContentColor = Color.White
                    )
                )
            },
            bottomBar = {
                if (!isDetailScreen.value) {
                    BottomNavigationBar(
                        navController = navController,
                        selectedItem = selectedItem,
                        currentScreenTitle = currentScreenTitle
                    )
                }
            },
            content = { padding ->
                NavHost(
                    navController = navController,
                    startDestination = Screen.Beranda.route,
                    modifier = Modifier.padding(padding)
                ) {
                    composable(Screen.Beranda.route) {
                        currentScreenTitle.value = "Nusantara"
                        TampilanBeranda(navController)
                    }
                    composable(Screen.RumahAdat.route) {
                        currentScreenTitle.value = "Rumah Adat"
                        TampilanRumahAdat(navController)
                    }
                    composable(Screen.Profil.route) {
                        currentScreenTitle.value = "Profil Saya"
                        TampilanProfil(navController)
                    }
                    composable(
                        route = Screen.DetailMakanan.route + "/{makananId}",
                        arguments = listOf(navArgument("makananId") { defaultValue = "-1" })
                    ) { backStackEntry ->
                        val makananId = backStackEntry.arguments?.getString("makananId") ?: "-1"
                        currentScreenTitle.value = "Detail Makanan"
                        DetailMakanan(makananId)
                    }
                    composable(
                        route = Screen.DetailProvinsi.route + "/{rumahAdatId}/{makananId}",
                        arguments = listOf(
                            navArgument("rumahAdatId") { defaultValue = "-1" },
                            navArgument("makananId") { defaultValue = "-1" }
                        )
                    ) { backStackEntry ->
                        val rumahAdatId = backStackEntry.arguments?.getString("rumahAdatId") ?: "-1"
                        val makananId = backStackEntry.arguments?.getString("makananId") ?: "-1"
                        currentScreenTitle.value = "Detail Nusantara"
                        DetailProvinsi(rumahAdatId, makananId)
                    }

                    composable(
                        route = Screen.DetailRumahAdat.route + "/{rumahAdatId}",
                        arguments = listOf(navArgument("rumahAdatId") { defaultValue = "-1" })
                    ) { backStackEntry ->
                        val rumahAdatId = backStackEntry.arguments?.getString("rumahAdatId") ?: "-1"
                        currentScreenTitle.value = "Detail Rumah Adat"
                        DetailRumahAdat(rumahAdatId)
                    }
                }
            }
        )
    }
}

@Composable
fun SplashScreen(navController: NavController) {
    // Splash Screen sederhana
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Toska),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), // Pastikan Anda punya gambar logo
            contentDescription = "Logo",
            modifier = Modifier.size(300.dp)
        )
    }
}

@Composable
fun BottomNavigationBar(
    navController: NavController,
    selectedItem: MutableState<String>,
    currentScreenTitle: MutableState<String>
) {
    val items = listOf(
        NavigationItem(Screen.Beranda, R.drawable.beranda, "Beranda"),
        NavigationItem(Screen.RumahAdat, R.drawable.rumah_adat, "Rumah Adat"),
        NavigationItem(Screen.Profil, R.drawable.profil, "Profil")
    )

    NavigationBar(
        containerColor = CardColor,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconRes),
                        contentDescription = item.label,
                        modifier = Modifier
                            .size(24.dp)  // Menyesuaikan ukuran ikon
                            .align(Alignment.CenterVertically)
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 0.dp)
                    )
                },
                selected = selectedItem.value == item.screen.route,
                onClick = {
                    selectedItem.value = item.screen.route
                    currentScreenTitle.value = item.label // Update judul saat tab diubah
                    navController.navigate(item.screen.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Toska,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = Toska,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NusantaraAppPreview() {
    NusantaraAppTheme {
        NusantaraApp()
    }
}
