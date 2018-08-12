package kyle.android.chatting.view.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
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
import kyle.android.chatting.model.User

class MainActivity : AppCompatActivity() {

    var db = FirebaseFirestore.getInstance()
    var user = mapOf(1 to "ewe")
    var hashMap = hashMapOf(1 to "ewe")
    var id: Long = 0L
    var binding: ActivityMainBinding? = null
    var adapter: InboxRecyclerViewAdapter? = null
    var inboxViewModel: InboxViewModel? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        inboxViewModel = ViewModelProviders.of(this).get(InboxViewModel::class.java)

        var layoutManager = LinearLayoutManager(this)
        binding?.recyclerView?.layoutManager = layoutManager

        adapter = InboxRecyclerViewAdapter()
        binding?.recyclerView?.adapter = adapter;

        inboxViewModel!!.inboxMutableLivedata.observe(this, Observer {

            if (it != null && !it.isEmpty()) {
                adapter!!.itemReset(it)
            }

        })


        inboxViewModel!!.getInboxList(this)



        sendBtn.setOnClickListener {
            var itemView = LayoutInflater.from(this).inflate(R.layout.item_message, null)
            var username = itemView?.findViewById<TextView>(R.id.username)
            var textview = itemView?.findViewById<TextView>(R.id.message)
            username?.setText("Kyle : ")
            textview?.setText(input?.text?.toString())

            var newInbox = Inbox(1, 72738, input.text.toString(), User(1, "test"))
            adapter!!.addItem(newInbox)
            db.collection("inbox").add(newInbox)
        }
    }
}
