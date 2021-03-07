package com.example.abnambrotest.db

import androidx.room.TypeConverter
import com.example.abnambrotest.networkinterface.remote.response.search.Categories
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
/**
 * Created by Darshan Patel
 * Usage: converters required to convert complex varaibles for room entity
 */
class Converters {
    @TypeConverter
    fun stringListToJson(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToStringList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()

    @TypeConverter
    fun stringListJson(value: List<Categories>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonStringList(value: String) =
        Gson().fromJson(value, Array<Categories>::class.java).toList()

    @TypeConverter
    fun fromString(value: String?): ArrayList<String?>? {
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<String?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
}