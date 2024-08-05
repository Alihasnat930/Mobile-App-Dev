package pk.edu.iqra.firstapp.utils

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Customer(val name:String,val dob:String, val mobileNo:String):Parcelable