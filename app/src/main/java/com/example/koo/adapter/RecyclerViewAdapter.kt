package com.example.koo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.koo.R
import com.example.koo.model.RecyclerData


class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){

    var items = ArrayList<RecyclerData>()

    fun setUpdatedData(items : ArrayList<RecyclerData>) {
        this.items = items
        notifyDataSetChanged()
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title= view.findViewById<TextView>(R.id.title)
        val body = view.findViewById<TextView>(R.id.body)

        fun bind(data : RecyclerData) {
            title.text = data.title
            body.text = data.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_data, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.bind(items.get(position))
    }
}