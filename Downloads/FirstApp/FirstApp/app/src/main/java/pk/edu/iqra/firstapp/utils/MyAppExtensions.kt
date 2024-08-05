package pk.edu.iqra.firstapp.utils

import android.widget.Button
import com.google.gson.Gson

fun Button.getButtonText(){

}

fun Customer.toJson():String{
    val gson = Gson()
    return gson.toJson(this)
}

fun convertArrayListToJson(list:ArrayList<Customer>):String{
    val gson = Gson()
    return gson.toJson(list)
}