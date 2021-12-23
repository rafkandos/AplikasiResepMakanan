package com.example.aplikasiresepmakanan

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ResepDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addResep(resep: Resep)

    @Query("SELECT * FROM Resep")
    fun getAllResep(): LiveData<MutableList<Resep>>

    @Delete
    fun deleteAddress(address: Resep)
}