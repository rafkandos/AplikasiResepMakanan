package com.example.aplikasiresepmakanan

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ResepDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addResep(resep: Resep)

    @Query("SELECT * FROM Resep")
    fun getAllResep(): LiveData<List<Resep>>

}