package com.evaph.core.base

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import androidx.viewbinding.ViewBinding

abstract class BaseDialog<V : ViewBinding>(context: Context) : Dialog(context) {

    lateinit var binding: V

    abstract fun initBinding(): V

    abstract fun onDialogCreated()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = initBinding()
        setContentView(binding.root)

        window!!.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
        window!!.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        setCancelable(true)

        onDialogCreated()
    }
}