package com.example.aplikasiresepmakanan

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Resep(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val nama: String,
    val alatBahan: String,
    val caraMemasak: String
) : Parcelable
