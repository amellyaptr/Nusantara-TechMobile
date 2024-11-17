package com.example.nusantaraapp.data

import com.example.nusantaraapp.R
import com.example.nusantaraapp.tipe.Makanan
import com.example.nusantaraapp.tipe.Provinsi
import com.example.nusantaraapp.tipe.RumahAdat

object DummyData {
    val provinsiIndonesia = listOf(
        Provinsi(
            id = 1,
            province = "Lampung",
            name = "Siger",
            imageRes = R.drawable.siger
        ),
        Provinsi(
            id = 2,
            province = "Sumatera Barat",
            name = "Jam Gadang",
            imageRes = R.drawable.sumbar
        ),
        Provinsi(
            id = 3,
            province = "Yogyakarta",
            name = "Tugu Jogja",
            imageRes = R.drawable.yogya
        ),
        Provinsi(
            id = 4,
            province = "Sumatera Selatan",
            name = "Jembatan Ampera",
            imageRes = R.drawable.sumsel
        ),
        Provinsi(
            id = 5,
            province = "Jakarta",
            name = "Monas",
            imageRes = R.drawable.jakarta
        ),
        Provinsi(
            id = 6,
            province = "Papua",
            name = "Rumah Honai",
            imageRes = R.drawable.papua
        ),
        Provinsi(
            id = 7,
            province = "Aceh",
            name = "Masjid Raya Baiturrahman",
            imageRes = R.drawable.aceh
        ),
        Provinsi(
            id = 8,
            province = "Sumatera Utara",
            name = "Masjid Raya Medan",
            imageRes = R.drawable.medan
        ),
        Provinsi(
            id = 9,
            province = "Jawa Timur",
            name = "Patung Sura dan Buaya",
            imageRes = R.drawable.jatim
        ),
        Provinsi(
            id = 10,
            province = "Bali",
            name = "Danau Bentaran",
            imageRes = R.drawable.bali
        )
    )

    val makananNusantara = listOf(
        Makanan(
            id = 1,
            province = "Lampung",
            name = "Seruit",
            imageRes = R.drawable.seruit
        ),
        Makanan(
            id = 2,
            province = "Sumatera Barat",
            name = "Rendang",
            imageRes = R.drawable.rendang
        ),
        Makanan(
            id = 3,
            province = "Yogyakarta",
            name = "Gudeg",
            imageRes = R.drawable.gudeg
        ),
        Makanan(
            id = 4,
            province = "Sumatera Selatan",
            name = "Pempek",
            imageRes = R.drawable.pempek
        ),
        Makanan(
            id = 5,
            province = "Jakarta",
            name = "Kerak Telor",
            imageRes = R.drawable.kerak_telor
        ),
        Makanan(
            id = 6,
            province = "Papua",
            name = "Papeda",
            imageRes = R.drawable.papeda
        ),
        Makanan(
            id = 7,
            province = "Aceh",
            name = "Mie Aceh",
            imageRes = R.drawable.mie_aceh
        ),
        Makanan(
            id = 8,
            province = "Sumatera Utara",
            name = "Bika Ambon",
            imageRes = R.drawable.bika_ambon
        ),
        Makanan(
            id = 9,
            province = "Jawa Timur",
            name = "Rujak Cingur",
            imageRes = R.drawable.rujakcingur
        ),
        Makanan(
            id = 10,
            province = "Bali",
            name = "Ayam Betutu",
            imageRes = R.drawable.ayambetutu
        )
    )

    val rumahNusantara = listOf(
        RumahAdat(
            id = 1,
            province = "Lampung",
            name = "Nuwou Sesat",
            imageRes = R.drawable.nuwousesat
        ),
        RumahAdat(
            id = 2,
            province = "Sumatera Barat",
            name = "Rumah Gadang",
            imageRes = R.drawable.rumahgadang
        ),
        RumahAdat(
            id = 3,
            province = "Yogyakarta",
            name = "Rumah Joglo",
            imageRes = R.drawable.joglojogja
        ),
        RumahAdat(
            id = 4,
            province = "Sumatera Selatan",
            name = "Rumah Limas",
            imageRes = R.drawable.limas
        ),
        RumahAdat(
            id = 5,
            province = "Jakarta",
            name = "Rumah Kebaya",
            imageRes = R.drawable.kebaya
        ),
        RumahAdat(
            id = 6,
            province = "Papua",
            name = "Rumah Adat Kariwari",
            imageRes = R.drawable.kariwari
        ),
        RumahAdat(
            id = 7,
            province = "Aceh",
            name = "Krong Bade",
            imageRes = R.drawable.krongbade
        ),
        RumahAdat(
            id = 8,
            province = "Sumatera Utara",
            name = "Bolon",
            imageRes = R.drawable.bolon
        ),
        RumahAdat(
            id = 9,
            province = "Jawa Timur",
            name = "Rumah Joglo",
            imageRes = R.drawable.joglo
        ),
        RumahAdat(
            id = 10,
            province = "Bali",
            name = "Gapura Candi Bentar",
            imageRes = R.drawable.gapura
        )
    )
}