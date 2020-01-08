package com.example.template.cache.model

import com.example.template.model.Address

internal data class AddressEntity(
    val city: String,
    val geo: GeoEntity,
    val street: String,
    val suite: String,
    val zipcode: String
)

internal fun AddressEntity.toAddress() = Address(
    city,
    geo.toGeo(),
    street,
    suite,
    zipcode
)