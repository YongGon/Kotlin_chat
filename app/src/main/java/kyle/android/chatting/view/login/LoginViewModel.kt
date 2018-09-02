package kyle.android.chatting.view.login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.FirebaseFirestore
import kyle.android.chatting.model.User
import kyle.android.chatting.util.Constant
import kyle.android.chatting.util.SharedPreferenceUtil
import kyle.android.chatting.view.base.BaseActivity

class LoginViewModel : ViewModel() {

    var isLoginStateLiveData: MutableLiveData<Boolean> = MutableLiveData()



    fun login(activity: BaseActivity, username: String) {

        // user table insert

        FirebaseFirestore.getInstance().collection("user")
                .add(User(1, username))
                .addOnSuccessListener { OnSuccessListener<User> {
                    // -- success
                    // move InboxList
                    // login data Save
//                    Log.e("LoginViewModel", "success")
//                    isLoginStateLiveData.value = true
                } }
                .addOnFailureListener(OnFailureListener {
                    // -- failed cautione
                    it.printStackTrace()
                    Log.e("LoginViewModel", "failed")
                    isLoginStateLiveData.value = false
                })
                .addOnCompleteListener(OnCompleteListener {
                    SharedPreferenceUtil.getInstance(activity)?.put(Constant.SP_KEY_USER_DATA, username)
                    isLoginStateLiveData.value = true
                })

    }

}