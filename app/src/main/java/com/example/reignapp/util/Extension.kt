package com.example.reignapp.util

import android.text.TextUtils

fun List<String>.listToString(): String =
    if (this.isNullOrEmpty()) {
        ""
    } else {
        TextUtils.join("@", this)
    }
