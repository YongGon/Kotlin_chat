package kyle.android.chatting.view.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore
import kyle.android.chatting.R
import kyle.android.chatting.model.Inbox

/**
 * Created by gon on 2018. 8. 7..
 */
class InboxViewModel : ViewModel() {

    var inboxMutableLivedata = MutableLiveData<MutableList<Inbox>>()
    var db = FirebaseFirestore.getInstance()

    fun getInboxList(context: Context) {
        db.collection("inbox")
        .get()
        .addOnCompleteListener(OnCompleteListener { task ->

            if (task.isSuccessful) {
                var items = task.getResult();
                inboxMutableLivedata.value = items as MutableList<Inbox>
            }
        })
    }

}