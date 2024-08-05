package pk.edu.iqra.firstapp.persistance.roomdatabase.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pk.edu.iqra.firstapp.persistance.roomdatabase.entities.Product

@Dao
interface ProductDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: Product):Long

    @Query("SELECT * FROM PRODUCT")
    suspend fun getAllProducts():List<Product>

    @Query("SELECT * FROM PRODUCT WHERE ID=:id")
    suspend fun getProduct(id:Long):Product

    @Delete
    suspend fun delete(product: Product)

    @Query("DELETE from PRODUCT")
    suspend fun deleteAll()
}