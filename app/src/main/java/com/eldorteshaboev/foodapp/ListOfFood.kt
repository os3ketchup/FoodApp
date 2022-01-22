package com.eldorteshaboev.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.Toast
import com.eldorteshaboev.foodapp.adapter.MyListAdapter
import com.eldorteshaboev.foodapp.cache.MySharedPreference
import com.eldorteshaboev.foodapp.utils.MyData
import kotlinx.android.synthetic.main.activity_list_of_food.*

class ListOfFood : AppCompatActivity() {
    lateinit var myListAdapter: MyListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_food)
        title = "All foods"
        MySharedPreference.init(this)
        val list = MySharedPreference.objectString

        myListAdapter = MyListAdapter(this, list)
        listViewOfFood.adapter = myListAdapter
        listViewOfFood.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this,DescriptionFood::class.java)
            intent.putExtra("position",i)
            startActivity(intent)
        }
    }
}