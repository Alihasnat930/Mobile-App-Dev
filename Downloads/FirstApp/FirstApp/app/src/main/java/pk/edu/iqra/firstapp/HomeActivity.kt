package pk.edu.iqra.firstapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import pk.edu.iqra.firstapp.databinding.ActivityHomeBinding
import pk.edu.iqra.firstapp.utils.Customer
import pk.edu.iqra.firstapp.utils.DataHolder
import pk.edu.iqra.firstapp.utils.User
import pk.edu.iqra.firstapp.utils.getButtonText

class HomeActivity : AppCompatActivity() {
    private val KEY_COUNTER = "counter"
    private var counter = 0
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)

        /*binding.counterButton.setOnClickListener {
            binding.counterTextView.text = "${++counter}"
        }*/
        val isCounterExists = savedInstanceState?.containsKey(KEY_COUNTER)?:false
        if(isCounterExists){
            counter = savedInstanceState?.getInt(KEY_COUNTER)?:0
            setCounterValue()
        }
        /*binding.apply {
            counterButton.setOnClickListener {
                counterTextView.text = "${++counter}"
            }
        }*/

        binding.counterButton.setOnClickListener(MyClickHandler(this))
        binding.navigateButton.setOnClickListener(MyClickHandler(this))
    }

    fun doIncrement(){
        ++counter
    }

    fun setCounterValue() {
        binding.counterTextView.text = "${counter}"
    }

    fun navigateToMainScreen(){
        //val user = User("Mr. Ali","April, 1996","035885545854")
        //val user = User(dob="April, 1996", mobileNo = "035885545854", name = "Mr. Ali")
        val customer = Customer(dob="April, 1996", mobileNo = "035885545854", name = "Mr. Ali")
        DataHolder.customer = customer
        val intent = Intent(this,MainActivity::class.java)
        /*intent.putExtra("counter",counter)
        intent.putExtra("username","Mr. Ali")
        intent.putExtra("dob","April, 1996")*/
        //intent.putExtra("user",user)
        //intent.putExtra("customer",customer)
        startActivity(intent)
    }

    class MyClickHandler(var activity: HomeActivity): View.OnClickListener {
        override fun onClick(p0: View?) {
            /*activity.doIncrement()
            activity.setCounterValue()*/

            when(p0?.id){
                R.id.counter_button -> {
                    activity.doIncrement()
                    activity.setCounterValue()
                }
                R.id.navigate_button -> {
                    activity.navigateToMainScreen()
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_COUNTER,counter)
        super.onSaveInstanceState(outState)
    }
}