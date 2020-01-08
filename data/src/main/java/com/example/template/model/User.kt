package com.example.template.model

import com.example.template.cache.model.UserEntity
import com.example.template.tools.BaseItem

data class User(
    override val id: Int,
    val address: Address,
    val company: Company,
    val email: String,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
) : BaseItem

internal fun User.toUserEntity() = UserEntity(
    id.toLong(),
    address.toAddressEntity(),
    company.toCompanyEntity(),
    email,
    name,
    phone,
    username,
    website
)

internal fun List<User>.toUserEntities() = map { it.toUserEntity() }