package com.eldorteshaboev.foodapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.eldorteshaboev.foodapp.cache.MySharedPreference
import com.eldorteshaboev.foodapp.models.Food
import kotlinx.android.synthetic.main.activity_adding_food.*

class AddingFood : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding_food)
        title = "Adding food"
        MySharedPreference.init(this)
        btn_save.setOnClickListener {
            val name = et_food_name.text.toString().trim()
            val ingredients = et_ingredients.text.toString().trim()
            val sequencesPreparation = et_preparation_order.text.toString().trim()
            if (name!=""&&ingredients!=""&&sequencesPreparation!=""){
                val list = MySharedPreference.objectString
                list.add(Food(name,ingredients,sequencesPreparation))
                MySharedPreference.objectString = list
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Please fill the gaps", Toast.LENGTH_SHORT).show()
            }

        }
    }
}