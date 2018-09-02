package kyle.android.chatting.util

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceUtil {

    var sharedPreferences: SharedPreferences? = null

    constructor(context: Context) {
        sharedPreferences = context.getSharedPreferences("preference", Context.MODE_PRIVATE)
    }


    companion object {

        var INSTANCE: SharedPreferenceUtil? = null;

        fun getInstance(context: Context): SharedPreferenceUtil? {

            if (INSTANCE == null) {
                INSTANCE = SharedPreferenceUtil(context)
            }

            return INSTANCE
        }

    }


    fun put(key: String, value: String) {
        sharedPreferences?.edit()?.putString(key, value)?.commit()
    }

    fun getValue(key: String): String? {
        return sharedPreferences?.getString(key, "")
    }


}