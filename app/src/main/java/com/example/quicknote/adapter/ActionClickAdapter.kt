package com.example.quicknote.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quicknote.databinding.ItemActionClickBinding
import com.example.quicknote.model.ActionClick

class ActionClickAdapter(
    private val callback: Callback,
    private val listButton: List<ActionClick>,
) : RecyclerView.Adapter<ActionClickAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemActionClickBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemActionClickBinding =
            ItemActionClickBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(listButton[position]) {
                binding.image.setImageResource(this.image)
                binding.root.setOnClickListener {
                    callback.onCLick(this.id)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listButton?.size ?: 0
    }

    interface Callback {
        fun onCLick(id: Int)
    }
}