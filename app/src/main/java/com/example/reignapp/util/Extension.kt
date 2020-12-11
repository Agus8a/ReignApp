package com.example.reignapp.util

import android.content.Context
import android.content.res.Configuration
import android.text.TextUtils
import androidx.fragment.app.Fragment
import com.example.reignapp.R
import com.example.reignapp.data.entity.HitEntity
import com.example.reignapp.data.model.Hit
import java.util.*
import kotlin.math.roundToInt

fun List<String>.listToString(): String =
    if (this.isNullOrEmpty()) {
        ""
    } else {
        TextUtils.join("@", this)
    }

fun Hit.getTitle(): String = if (this.storyTitle.isNullOrEmpty()) {
    this.title!!
} else {
    this.storyTitle
}

fun Hit.getAuthorAndDate(context: Context): String {
    val c1 = Calendar.getInstance()
    val c2 = Calendar.getInstance()
    c1.timeInMillis = System.currentTimeMillis()
    c2.timeInMillis = if (this.created > 0L) {
        this.created * 1000
    } else {
        c1.timeInMillis
    }
    val diff: Long = c1.timeInMillis - c2.timeInMillis
    val minutes = diff / (1000 * 60)
    val hours = minutes / 60

    val hoursPassed =
        when {
            minutes < 60 -> {
                minutes.toDouble().roundToInt().toString() + context.getString(R.string.min)
            }
            hours < 24 -> {
                hours.toDouble().roundToInt().toString() + "h"
            }
            hours in 24..48 -> {
                context.getString(R.string.yesterday)
            }
            else -> context.getString(R.string.days_ago)
        }

    val author = if (this.author.isNullOrEmpty()) {
        context.getString(R.string.anonymous)
    } else {
        this.author
    }
    return "$author - $hoursPassed"
}

fun Fragment.receiveSafeString(key: String): String =
        try {
            if (this.requireArguments().containsKey(key)) {
                this.requireArguments().getString(key) ?: ""
            } else {
                ""
            }
        } catch (e: Exception) {
            ""
        }

fun HitEntity.getTitle(): String = if (this.storyTitle.isNullOrEmpty()) {
    this.title!!
} else {
    this.storyTitle
}

fun Context.isNightModeActive(): Boolean =
        this.resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES