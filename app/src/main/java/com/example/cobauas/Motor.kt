package com.example.cobauas

data class Motor(
    val nama:String,
    val service : String,
    var status : status
)

enum class status{
    selesai,
    akan_datang
}