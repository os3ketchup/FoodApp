package com.eldorteshaboev.foodapp.cache

import android.content.Context
import android.content.SharedPreferences
import com.eldorteshaboev.foodapp.models.Food
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


object MySharedPreference {
    private const val NAME = "toCashes"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(NAME, MODE)

    }


    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }


    var objectString: ArrayList<Food>
        get() = gsonStringToArray(sharedPreferences.getString("object", "[]")!!)
        set(value) = sharedPreferences.edit {
            it.putString("object", arrayToGsonString(value))
        }


    private fun gsonStringToArray(gsonString: String): ArrayList<Food> {
        val typeToken = object : TypeToken<ArrayList<Food>>() {}.type
        return Gson().fromJson(gsonString, typeToken)
    }

    private fun arrayToGsonString(arrayList: ArrayList<Food>): String? {
        return Gson().toJson(arrayList)
    }
}
