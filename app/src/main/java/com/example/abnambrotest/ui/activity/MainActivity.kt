package com.example.abnambrotest.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abnambrotest.BR
import com.example.abnambrotest.R
import com.example.abnambrotest.base.BaseActivity
import com.example.abnambrotest.base.BaseApplication
import com.example.abnambrotest.databinding.ActivityMainBinding
import com.example.databindingdemo.util.log.CustomLogger
import org.koin.android.viewmodel.ext.android.viewModel

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
