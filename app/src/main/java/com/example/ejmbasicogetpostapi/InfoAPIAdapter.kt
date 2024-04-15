package com.example.ejmbasicogetpostapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class InfoAPIAdapter(private val infoAPI: MutableList<PostModelResponse>) : RecyclerView.Adapter<InfoAPIViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoAPIViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return InfoAPIViewHolder(layoutInflater.inflate(R.layout.item_infoapi, parent, false))
    }

    override fun getItemCount(): Int = infoAPI.size

    override fun onBindViewHolder(holder: InfoAPIViewHolder, position: Int) {
        val item = infoAPI[position]
        holder.bind(item)
      }
}