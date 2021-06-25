package com.projectdidit.tubes.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.projectdidit.tubes.User.ListPariwisata
import com.projectdidit.tubes.R

class UserAdapter (private val listMenu: ArrayList<ListPariwisata>) : RecyclerView.Adapter<UserAdapter.ListViewHolder> () {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind (menu : ListPariwisata){
            with(itemView){

                var tvItemName: TextView = itemView.findViewById(R.id.tv_item_name)
                var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)


                tvItemName.text = menu.destinasi
                tvDetail.text = menu.deskripsi
            }
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.rv, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMenu[position])

    }

    override fun getItemCount(): Int {
        return listMenu.size
    }
}