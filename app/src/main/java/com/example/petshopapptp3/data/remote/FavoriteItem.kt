package com.example.petshopapptp3.data.remote

data class FavoriteItem(
    val id: Int = 0,
    val title: String = "",
    val price: Double = 0.0,
    val thumbnail: String = "",
    val addedAt: Long = 0L
)