package com.example.aplikasiresepmakanan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_card_resep.*
import kotlinx.android.synthetic.main.fragment_resep.*

class ResepAdapter(private val context: Context, private val items: ArrayList<Resep>) :
    RecyclerView.Adapter<ResepAdapter.ViewHolder>() {
    var listener: RecyclerViewClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_card_resep, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position))
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item: Resep) {
            txtCard.text = item.nama

            containerView.setOnClickListener { v: View ->
                var position: Int? = item.id
                val activity = MainActivity()
                activity.tampilToast(position.toString())
            }
        }
    }
}
