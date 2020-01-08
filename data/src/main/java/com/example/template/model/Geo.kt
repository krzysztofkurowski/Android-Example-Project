package com.example.template.model

import com.example.template.cache.model.GeoEntity

data class Geo(
    val lat: String,
    val lng: String
)

internal fun Geo.toGeoEntity() = GeoEntity(
    lat,
    lng
)