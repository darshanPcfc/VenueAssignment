package com.example.venueassignment.ui.activity

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import android.view.View
import com.example.venueassignment.BR
import com.example.venueassignment.BuildConfig
import com.example.venueassignment.R
import com.example.venueassignment.base.BaseActivity
import com.example.venueassignment.databinding.ActivityMainBinding
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

    override fun onCreate(savedInstanceState: Bundle?) {
        if (BuildConfig.DEBUG) {
            StrictMode.setVmPolicy(
                VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build()
            )
        }
        super.onCreate(savedInstanceState)
        activityMainBinding = this.viewDataBinding!!
    }
}
