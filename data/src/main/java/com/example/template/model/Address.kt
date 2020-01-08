package com.example.template.model

import com.example.template.cache.model.AddressEntity

data class Address(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
)

internal fun Address.toAddressEntity() = AddressEntity(
    city,
    geo.toGeoEntity(),
    street,
    suite,
    zipcode
)