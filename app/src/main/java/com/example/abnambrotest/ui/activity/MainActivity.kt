package com.example.abnambrotest.ui.activity

import android.os.Bundle
import com.example.abnambrotest.BR
import com.example.abnambrotest.R
import com.example.abnambrotest.base.BaseActivity
import com.example.abnambrotest.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Darshan Patel
 * Usage: main activity and launcher activity for app
 */
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>(),
    IMainActivityNavigator {

    override val viewModel: MainActivityViewModel by viewModel()
    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.activity_main
    lateinit var activityMainBinding: ActivityMainBinding
    val TAG: String = "MAIN_Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = this.viewDataBinding!!
    }
}
