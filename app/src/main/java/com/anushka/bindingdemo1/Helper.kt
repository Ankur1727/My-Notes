package com.mynotes.notes

import android.content.Context
import android.widget.Toast

fun Context.toast(messString: String)=
    Toast.makeText(this,messString,Toast.LENGTH_LONG).show()