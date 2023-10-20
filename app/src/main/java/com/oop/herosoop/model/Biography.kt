package com.oop.herosoop.model

data class Biography(
    val fullName: String,
    val alterEgos: String,
    val aliases: List <String>,
    val placeOfBirth: List <String>,
    val firstAppearance: String,
    val publisher: String,
    val alignment: String
)