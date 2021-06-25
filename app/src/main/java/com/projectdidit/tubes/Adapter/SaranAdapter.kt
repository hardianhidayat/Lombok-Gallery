package com.projectdidit.tubes.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.projectdidit.tubes.R

class SaranAdapter (private val listSaran: ArrayList<Saran>) : RecyclerView.Adapter<SaranAdapter.SaranViewHolder> () {

    inner class SaranViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind (menu : Saran){
            with(itemView){
                val tv_saran = itemView.findViewById<TextView>(R.id.tvSaran)
                tv_saran.text = menu.saranUser
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaranViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_saran, parent, false)
        return SaranViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listSaran.size
    }

    override fun onBindViewHolder(holder: SaranViewHolder, position: Int) {
        holder.bind(listSaran[position])
    }


}