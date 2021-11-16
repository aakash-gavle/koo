package com.example.koo.model

data class RecyclerList(
    val data: ArrayList<RecyclerData>
    )

data class RecyclerData(
    val title : String,
    val body: String
    )
