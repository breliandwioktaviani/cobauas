package com.example.cobauas

data class Motor(
    val merk: String,
    val jenis: String,
    val nomor: String,
    val terakhir: String,
    val selanjutnya: String,
    var status: status,
    var catatan: String
)


data class TambahRiwayat(
    val nama:String,
    var status: status
)

enum class status{
    selesai,
    akan_datang
}

