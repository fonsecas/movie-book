package com.example.moviebook.presentation.util.extensions

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.Window

fun Context.makeStatusBarTransparent(window: Window) {
    window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    window.statusBarColor = Color.TRANSPARENT
}
