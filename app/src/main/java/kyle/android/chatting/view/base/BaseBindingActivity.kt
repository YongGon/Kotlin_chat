package kyle.android.chatting.view.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle

abstract class BaseBindingActivity<T : ViewDataBinding> : BaseActivity() {

    var binding: T? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this, getLayoutResId())

        super.onCreate(savedInstanceState)
    }

}