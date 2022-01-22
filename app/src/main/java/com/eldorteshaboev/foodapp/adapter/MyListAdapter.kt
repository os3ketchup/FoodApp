package com.eldorteshaboev.foodapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.eldorteshaboev.foodapp.R
import com.eldorteshaboev.foodapp.models.Food
import kotlinx.android.synthetic.main.item_rv.view.*

class MyListAdapter(context: Context, val list: List<Food>):ArrayAdapter<Food>(context, R.layout.item_rv,list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val itemView:View
            if (convertView==null){
                itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false)
            }else{
                itemView = convertView
            }
        itemView.tv_item_food_name.text = list[position].nameFood
        return itemView
    }

}