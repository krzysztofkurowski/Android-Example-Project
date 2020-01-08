package com.example.template.remote.model

import com.example.template.model.User

internal data class UserDto(
    val address: AddressDto,
    val company: CompanyDto,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)

internal fun UserDto.toUser() = User(
    id,
    address.toAddress(),
    company.toCompany(),
    email,
    name,
    phone,
    username,
    website
)

internal fun List<UserDto>.toUsers() = map { it.toUser() }