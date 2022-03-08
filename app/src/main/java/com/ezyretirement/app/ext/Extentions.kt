package com.ezyretirement.app.ext

import android.content.Context
import android.content.res.Resources.getSystem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ezyretirement.app.R
import com.google.android.material.textfield.TextInputLayout
import java.text.DateFormat
import java.util.*

fun AppCompatActivity.commitFragment(fragment: Fragment) {
    this.supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
}


fun Fragment.replaceFragmentWith(fragment: Fragment){
    this.parentFragmentManager.beginTransaction()
        .addToBackStack("FRAG")
        .replace(R.id.container,fragment).commit()
}

fun AppCompatImageView.load(context: Context,url:String){
    if (url.isEmpty()) return
    Glide.with(context).load(url).into(this)
}


fun Long.toDateString(dateFormat: Int =  DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}


fun Fragment.isInputsValid(vararg inputs:TextInputLayout) :Boolean{
    val size = inputs.size
    var validCounter = 0

    inputs.forEach { input ->
        input.editText?.text?.length!! > 3
        validCounter++
    }

    return validCounter >= size
}



val Int.dp: Int get() = (this / getSystem().displayMetrics.density).toInt()