package pk.edu.iqra.firstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import pk.edu.iqra.firstapp.databinding.ActivityProductsBinding
import pk.edu.iqra.firstapp.persistance.preferences.PrefKeys
import pk.edu.iqra.firstapp.persistance.preferences.PrefManager
import pk.edu.iqra.firstapp.utils.Customer
import pk.edu.iqra.firstapp.utils.convertArrayListToJson
import java.util.ArrayList

class ProductsActivity : AppCompatActivity() {
    private var counter = 0
    private lateinit var binding:ActivityProductsBinding
    private lateinit var prefManager: PrefManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_products)

        prefManager = PrefManager(this)

        if(prefManager.contain(PrefKeys.COUNTER)){
            val counterStr = prefManager.getData(PrefKeys.COUNTER,"0")?:"0"
            counter = counterStr.toInt()
            showIncrementVal()
        }

        binding.buttonIncrement.setOnClickListener {
            doIncrement()
            showIncrementVal()
        }

        binding.buttonCustomerData.setOnClickListener {
            val customer1 = Customer("Mr. Ali Ahmed","15-08-2002","+92-344-5365555")
            val customer2 = Customer("Mr. Ayaz Ahmed","16-08-2002","+92-344-5365555")

            val listOfCustomer = ArrayList<Customer>()
            listOfCustomer.add(customer1)
            listOfCustomer.add(customer2)

            //prefManager.setData(PrefKeys.CUSTOMER, customer1.toJson())
            prefManager.setData(PrefKeys.CUSTOMER, convertArrayListToJson(listOfCustomer))
            /*if(prefManager.contain(PrefKeys.CUSTOMER)) {
                val customerStr = prefManager.getData(PrefKeys.CUSTOMER, "") ?: ""
                if(customerStr.isNotEmpty()){
                    val gson = Gson()
                    val custObj = gson.fromJson(customerStr,Customer::class.java)
                    Toast.makeText(this@ProductsActivity,"Name : ${custObj.name}",Toast.LENGTH_SHORT).show()
                }
            }*/
        }
    }

    private fun doIncrement(){
        ++counter
        persistIncrementValue()
    }

    private fun showIncrementVal(){
        binding.textIncrement.text = "$counter"
    }

    private fun persistIncrementValue(){
        prefManager.setData(PrefKeys.COUNTER, counter.toString())
    }
}