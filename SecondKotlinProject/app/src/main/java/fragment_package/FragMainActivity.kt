package fragment_package

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secondkotlinproject.R
import kotlinx.android.synthetic.main.activity_frag_main.*

class FragMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag_main)

        buttonRed.setOnClickListener{
            var redFrag=RedFragment()
            var fmanager=supportFragmentManager
            var fTransaction=fmanager.beginTransaction()
            fTransaction.replace(R.id.fragmentGreen,redFrag)
            fTransaction.commit()
        }
        buttonBlue.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentGreen,BlueFragment()).commit()
        }
    }
}