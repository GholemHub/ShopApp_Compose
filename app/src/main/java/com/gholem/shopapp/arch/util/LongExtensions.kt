package com.gholem.shopapp.util

import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
fun Long.timestampToString(): String {
    val sdf = SimpleDateFormat("dd.MM.yyyy")
    return sdf.format(Date(this))
}