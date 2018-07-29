package kyle.android.chatting.view.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kyle.android.chatting.R

class MainActivity : AppCompatActivity() {

    var db = FirebaseFirestore.getInstance()
    var user = mapOf(1 to "ewe")
    var hashMap = hashMapOf(1 to "ewe")
//    var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendBtn.setOnClickListener {
            var itemView = LayoutInflater.from(this).inflate(R.layout.item_message, null)
            var username = itemView?.findViewById<TextView>(R.id.username)
            var textview = itemView?.findViewById<TextView>(R.id.message)
            username?.setText("Kyle : ")
            textview?.setText(input?.text?.toString())
            layout?.addView(itemView)
            input.setText("")
        }





    }
}
