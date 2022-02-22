package com.ezyretirement.app.ext

import android.content.Context
import android.content.res.Resources.getSystem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ezyretirement.app.R

fun AppCompatActivity.commitFragment(fragment: Fragment) {
    this.supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
}


fun Fragment.replaceFragmentWith(fragment: Fragment){
    this.parentFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
}

fun AppCompatImageView.load(context: Context,url:String){
    if (url.isEmpty()) return
    Glide.with(context).load(url).into(this)
}






val Int.dp: Int get() = (this / getSystem().displayMetrics.density).toInt()