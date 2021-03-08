package com.example.databindingdemo.util.log

import timber.log.Timber
import timber.log.Timber.*

/*
* Created by Darshan Patel
* Usage: to print logs
* How to call: Singleton class, ClassName.methodName()
*/
object CustomLogger {

    init {
        plant(CrashReportingTree())
    }

    fun d(tag: String, s: String, vararg params: Any) =
        tag(tag).d(s, params)

    fun d(tag: String, throwable: Throwable, s: String, vararg params: Any) =
        tag(tag).d(throwable, s, params)

    fun i(tag: String, s: String, vararg params: Any) =
        tag(tag).i(s, params)

    fun i(tag: String, throwable: Throwable, s: String, vararg params: Any) =
        tag(tag).i(throwable, s, params)

    fun w(tag: String, s: String, vararg params: Any) =
        tag(tag).w(s, params)

    fun w(tag: String, throwable: Throwable, s: String, vararg params: Any) =
        tag(tag).w(throwable, s, params)

    fun e(tag: String, s: String, vararg params: Any) =
        tag(tag).e(s, params)

    fun e(tag: String, throwable: Throwable, s: String, vararg params: Any) =
        tag(tag).e(throwable, s, params)

    fun d(s: String, vararg params: Any) =
        Timber.d(s, params)

    fun d(throwable: Throwable, s: String, vararg params: Any) =
        Timber.d(throwable, s, params)

    fun i(s: String, vararg params: Any) =
        Timber.i(s, params)

    fun i(throwable: Throwable, s: String, vararg params: Any) =
        Timber.i(throwable, s, params)

    fun w(s: String, vararg params: Any) =
        Timber.w(s, params)

    fun w(throwable: Throwable, s: String, vararg params: Any) =
        Timber.w(throwable, s, params)

    fun e(s: String, vararg params: Any) =
        Timber.e(s, params)

    fun e(throwable: Throwable, s: String, vararg params: Any) =
        Timber.e(throwable, s, params)
}
