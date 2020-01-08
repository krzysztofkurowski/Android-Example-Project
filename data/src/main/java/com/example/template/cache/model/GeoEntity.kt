package com.example.template.cache.model

import com.example.template.model.Geo

internal data class GeoEntity(
    val lat: String,
    val lng: String
)

internal fun GeoEntity.toGeo() = Geo(
    lat,
    lng
)