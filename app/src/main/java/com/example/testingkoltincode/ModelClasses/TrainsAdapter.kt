package com.example.testingkoltincode.ModelClasses

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testingkoltincode.R

class TrainsAdapter(val context: Context, val wineList: List<GetWineClass>): RecyclerView.Adapter<TrainsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return wineList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val wine = wineList[position]
        var name =  wineList.get(position).wineName

        var tagn=  holder.itemView.findViewById<TextView>(R.id.wineName)

        tagn.text = name.toString()


        holder.itemView.setOnClickListener {





            Log.w("Train Adapter", "infoT.get(position) Train Num" + name)



            holder.setData(wineList.get(position))



        }




    }

    inner class  MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(wineClass: GetWineClass) {




        }
    }
}




