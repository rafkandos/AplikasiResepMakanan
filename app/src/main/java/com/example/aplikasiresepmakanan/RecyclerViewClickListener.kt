package com.example.aplikasiresepmakanan

import android.view.View

interface RecyclerViewClickListener {
    fun onItemClicked(view: View, resep: Resep)
}