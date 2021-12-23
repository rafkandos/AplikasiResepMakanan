package com.example.aplikasiresepmakanan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_card_resep.*
import kotlinx.android.synthetic.main.fragment_card_resep.view.*

class ResepAdapter(
    private val context: Context,
    private val items: ArrayList<Resep>,
    private val recyclerViewClickListener: RecyclerViewClickListener
) :
    RecyclerView.Adapter<ResepAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.fragment_card_resep, parent, false),
            recyclerViewClickListener
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(
        override val containerView: View,
        private val recyclerViewClickListener: RecyclerViewClickListener
    ) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bindItem(item: Resep) {
            txtCard.text = item.nama

            containerView.btnDeleteCard.setOnClickListener {
                recyclerViewClickListener.onDeleteItem(containerView, item)
            }
            containerView.card_view.setOnClickListener { v: View ->
                recyclerViewClickListener.onItemClicked(containerView, item)
            }
        }
    }
}
