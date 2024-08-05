package pk.edu.iqra.firstapp.persistance.roomdatabase.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PRODUCT")
data class Product(
    @PrimaryKey(autoGenerate = true) @ColumnInfo("ID") var id:Int = 0,
    @ColumnInfo("PRODUCT_NAME") val name:String,
    @ColumnInfo("CATEGORY") val category:String,
    @ColumnInfo("QUANTITY") val quantity:Int,
    @ColumnInfo("PRICE") val price:Double
)
