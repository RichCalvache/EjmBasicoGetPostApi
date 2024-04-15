package com.example.ejmbasicogetpostapi

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ejmbasicogetpostapi.databinding.ItemInfoapiBinding

class InfoAPIViewHolder (view: View): RecyclerView.ViewHolder(view) {

    private val binding =ItemInfoapiBinding.bind(view)

    //fun bind(id: PostModelResponse, titulo:String, cuerpo:String ){
    fun bind(infoAPI: PostModelResponse){
        binding.textviewRecyclerId.text = infoAPI.id.toString()
        binding.textviewRecyclerTitle.text = infoAPI.title
        binding.textviewRecyclerBody.text = infoAPI.body

    }



}