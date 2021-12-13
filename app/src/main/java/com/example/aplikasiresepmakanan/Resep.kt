package com.example.aplikasiresepmakanan

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Resep(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val nama : String,
    val alatBahan : String,
    val caraMemasak : String
)
