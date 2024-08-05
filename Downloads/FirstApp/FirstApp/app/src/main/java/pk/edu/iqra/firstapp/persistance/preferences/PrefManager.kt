package pk.edu.iqra.firstapp.persistance.preferences

import android.content.Context
import android.content.SharedPreferences

class PrefManager(context:Context) {
    private var preferences: SharedPreferences

    init {
        preferences = context.getSharedPreferences("my_app_pref",Context.MODE_PRIVATE)
    }

    fun contain(key:String):Boolean{
        if(preferences.contains(key)) return true
        return false
    }

    fun getData(key:String, defaultVal:String):String? {
        return preferences.getString(key,defaultVal)
    }

    fun setData(key:String, value:String){
       preferences.edit().putString(key,value).apply()
    }

    fun clear() = preferences.edit().clear().apply()
}