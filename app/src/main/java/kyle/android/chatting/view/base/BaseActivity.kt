package kyle.android.chatting.view.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getLayoutResId(): Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        initData()

        initViews()
    }

    open fun initData() {

    }

    open fun initViews() {

    }


}