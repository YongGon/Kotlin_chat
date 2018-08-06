package kyle.android.chatting.view.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kyle.android.chatting.R
import kyle.android.chatting.databinding.ActivityMainBinding
import kyle.android.chatting.model.Inbox

class MainActivity : AppCompatActivity() {

    var db = FirebaseFirestore.getInstance()
    var user = mapOf(1 to "ewe")
    var hashMap = hashMapOf(1 to "ewe")
    var id: Long = 0L
    var binding: ActivityMainBinding? = null
    var adapter: InboxRecyclerViewAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var list = arrayListOf<Inbox>(
                Inbox(1, 72738, "test"),
                Inbox(1, 72738, "test"),
                Inbox(1, 72738, "test")
        )

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var layoutManager = LinearLayoutManager(this)
        binding?.recyclerView?.layoutManager = layoutManager

        adapter = InboxRecyclerViewAdapter(list)
        binding?.recyclerView?.adapter = adapter;





        // 대화내용을 가져온다.
        db.collection("inbox").get()
                .addOnCompleteListener(OnCompleteListener { task ->

                    if (task.isSuccessful) {
                        var items = task.getResult();
                        for (item in items) {

                            var itemView = LayoutInflater.from(this).inflate(R.layout.item_message, null)
                            var username = itemView?.findViewById<TextView>(R.id.username)
                            var textview = itemView?.findViewById<TextView>(R.id.message)
                            username?.setText("Kyle : ")
                            textview?.setText(item["message"].toString())
//                            layout?.addView(itemView)
                        }
                    }
                })



        sendBtn.setOnClickListener {
            var itemView = LayoutInflater.from(this).inflate(R.layout.item_message, null)
            var username = itemView?.findViewById<TextView>(R.id.username)
            var textview = itemView?.findViewById<TextView>(R.id.message)
            username?.setText("Kyle : ")
            textview?.setText(input?.text?.toString())
//            layout?.addView(itemView)

//            var inbox = Inbox()
//            inbox.id = id++
//            inbox.userId = 1
//            inbox.message = input?.text.toString()
//            input.setText("")

//            db.collection("inbox").add(inbox)
        }
    }
}
