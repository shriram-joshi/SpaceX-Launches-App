package com.sj.spacexlaunches

import androidx.lifecycle.MutableLiveData

interface OnGetDataListenerInterface {
    fun onStart()
    fun onSuccess(data: Any)
    fun onFailed(t: Throwable)
}