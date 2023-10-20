package com.oop.herosoop.model

data class SuperHero (
    val id: Int,
    val name: String,
    val slug: String,
    val powerStats: PowerStats,
    val appearance: Appearance,
    val biography: Biography,
    val work: Work,
    val connections: Connections,
    val images: Images
)