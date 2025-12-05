package com.example.cobauas

data class Motor(
    var merk: String,
    var jenis: String,
    var nomor: String,
    var terakhir: String,
    var selanjutnya: String,
    var status: status,
    var catatan: String
)


data class TambahRiwayat(
    var nama:String,
    var status: status
)

enum class status{
    selesai,
    akan_datang
}

