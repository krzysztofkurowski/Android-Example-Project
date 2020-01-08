package com.example.template.remote.model

import com.example.template.model.Geo

internal data class GeoDto(
    val lat: String,
    val lng: String
)

internal fun GeoDto.toGeo() = Geo(
    lat,
    lng
)