package com.example.nusantaraapp.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Beranda : Screen("beranda")
    object RumahAdat : Screen("rumah_adat")
    object Profil : Screen("profil")
    object DetailMakanan : Screen("detail_makanan")
    object DetailProvinsi : Screen("detail_provinsi")
    object DetailRumahAdat : Screen("detail_rumah_adat")
}