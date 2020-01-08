package com.example.template.remote.model

import com.example.template.model.Company

data class CompanyDto(
    val bs: String,
    val catchPhrase: String,
    val name: String
)

fun CompanyDto.toCompany() = Company(
    bs,
    catchPhrase,
    name
)