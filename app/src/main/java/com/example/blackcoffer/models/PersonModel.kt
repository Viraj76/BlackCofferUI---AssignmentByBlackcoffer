package com.example.blackcoffer.models

import android.media.Image
import android.widget.ProgressBar

data class PersonModel (
    val personImage : Int,
    val personName : String,
    val personLocation : String,
    val personDistance : String,
    val progressBar: Int,
    val personInterest : String,
    val personDescription : String,
    var isExpandable : Boolean=false,

    )
