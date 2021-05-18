package com.evaph.core.base

import com.evaph.network.model.ErrorModel

interface BaseView {

    fun onError(error: ErrorModel)

    fun showLoading()

    fun hideLoading()

    fun showSuccessMsg(msg: String)

    fun showErrorMsg(msg: String)
}