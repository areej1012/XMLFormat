package com.example.xmlformat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlformat.databinding.ItemRowBinding

class RecycleAdpter(var listStudent: List<Student>): RecyclerView.Adapter<RecycleAdpter.ItemViewHolder>() {
    class ItemViewHolder(var binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
       return ItemViewHolder(ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       val list = listStudent
        holder.binding.apply {
            tvName.text = list[position].name
            tvGarde.text = list[position].garde.toString()
        }
    }

    override fun getItemCount(): Int = listStudent.size
}