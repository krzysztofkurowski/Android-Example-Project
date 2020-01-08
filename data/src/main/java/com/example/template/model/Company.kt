package com.example.template.model

import com.example.template.cache.model.CompanyEntity

data class Company(
    val bs: String,
    val catchPhrase: String,
    val name: String
)

internal fun Company.toCompanyEntity() = CompanyEntity(
    bs,
    catchPhrase,
    name
)