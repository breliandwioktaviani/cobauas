package com.example.cobauas

data class Motor(
    val merk: String,
    val jenis: String,
    val nomor: String,
    val terakhir: String,
    val selanjutnya: String,
    val status: status
)


data class Riwayat(
    val nama:String,
    var status: status
)

enum class status{
    selesai,
    akan_datang
}

