package kyle.android.chatting.util

import android.content.Intent
import kyle.android.chatting.view.base.BaseActivity
import kyle.android.chatting.view.home.MainActivity

class NavigationUtil {


    companion object {

        fun startInboxActivity(activity: BaseActivity, username: String) {

            var intent: Intent = Intent(activity, MainActivity::class.java)
            intent.putExtra("username", username)
            activity.startActivity(intent)
            activity.finish()
        }
    }
}