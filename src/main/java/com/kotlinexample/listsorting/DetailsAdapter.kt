package com.kotlinexample.listsorting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class DetailsAdapter(private val mutableList: MutableList<DetailsView>, var detailsAdapterListener : DetailsAdapterListener) : RecyclerView.Adapter<DetailsAdapter.ViewHolder>(){

    private var listData: MutableList<DetailsView> = mutableList


    class ViewHolder(detailsView: View) : RecyclerView.ViewHolder(detailsView) {

        val tv_name : TextView = itemView.findViewById(R.id.name)
        val tv_age : TextView = itemView.findViewById(R.id.age)
        val tv_city : TextView = itemView.findViewById(R.id.city)
        val tv_dob : TextView = itemView.findViewById(R.id.dob)
        val chk_select : CheckBox = itemView.findViewById(R.id.chk_select)
        val img_delete : (ImageView) = itemView.findViewById(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_details_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val detailsView = mutableList[position]

        holder.tv_name.text = "Name :  " + detailsView.Name
        holder.tv_age.text = "Age :  " + detailsView.Age
        holder.tv_city.text = "City :  " + detailsView.City
        holder.tv_dob.text = "DOB :  " + detailsView.DOB

        holder.chk_select.isChecked = detailsView.isDetailChecked

        holder.chk_select.setOnClickListener(View.OnClickListener {
            //detailsView.isDetailChecked = holder.chk_select.isChecked
            detailsAdapterListener.onChecked(holder.chk_select.isChecked, position)

        })

        holder.img_delete.setOnClickListener(View.OnClickListener {
            listData.removeAt(position)
            notifyDataSetChanged()
        })
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    interface DetailsAdapterListener{
        fun onChecked(isChecked : Boolean, position: Int)

      //  fun onDeleted(position: Int)
    }

}