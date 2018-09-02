package kyle.android.chatting.view.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.text.TextUtils
import kyle.android.chatting.R
import kyle.android.chatting.databinding.ActivityLoginBinding
import kyle.android.chatting.util.Constant
import kyle.android.chatting.util.NavigationUtil
import kyle.android.chatting.util.SharedPreferenceUtil
import kyle.android.chatting.view.base.BaseBindingActivity

class LoginActivity : BaseBindingActivity<ActivityLoginBinding>() {


    var loginViewModel: LoginViewModel? = null;

    override fun getLayoutResId(): Int {
        return R.layout.activity_login
    }

    override fun initData() {
        super.initData()

        if (!TextUtils.isEmpty(SharedPreferenceUtil.getInstance(this)?.getValue(Constant.SP_KEY_USER_DATA))) {
            NavigationUtil.startInboxActivity(this, binding?.evUsername?.text.toString())
        }

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    override fun initViews() {
        super.initViews()

        setLogin()

        setLiveDataObserves()
    }

    private fun setLiveDataObserves() {

        loginViewModel?.isLoginStateLiveData?.observe(this, Observer {
            if (it == null || !it) return@Observer

            NavigationUtil.startInboxActivity(this, binding?.evUsername?.text.toString())
        })

    }

    fun setLogin() {

        binding?.login?.setOnClickListener {
            loginViewModel?.login(this, binding?.evUsername?.text.toString())
        }
    }

}

