package com.ehb.cricket.classes

data class Matches (
    val id: String,
    val name: String,
    val matchType: String,
    val status:String,
    val venue: String,
    val dateTimeGMT: String,
)