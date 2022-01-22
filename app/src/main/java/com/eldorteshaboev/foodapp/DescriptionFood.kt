package com.eldorteshaboev.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eldorteshaboev.foodapp.cache.MySharedPreference
import com.eldorteshaboev.foodapp.utils.MyData
import kotlinx.android.synthetic.main.activity_description_food.*

class DescriptionFood : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description_food)
        supportActionBar?.hide()

        MySharedPreference.init(this)
        val list = MySharedPreference.objectString
        val position = intent.getIntExtra("position",0)
        tv_name.text = list[position].nameFood
        tvOfFood.text = list[position].ingredients
        aboutPreparation.text = list[position].sequencesOfPreparing
    }
}