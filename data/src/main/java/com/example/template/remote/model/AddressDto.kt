package com.example.template.remote.model

import com.example.template.model.Address

internal data class AddressDto(
    val city: String,
    val geo: GeoDto,
    val street: String,
    val suite: String,
    val zipcode: String
)

internal fun AddressDto.toAddress() = Address(
    city,
    geo.toGeo(),
    street,
    suite,
    zipcode
)