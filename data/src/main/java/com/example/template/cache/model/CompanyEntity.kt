package com.example.template.cache.model

import androidx.room.ColumnInfo
import com.example.template.model.Company

internal data class CompanyEntity(
    val bs: String,
    val catchPhrase: String,
    @ColumnInfo(name = COLUMN_NAME)
    val name: String
) {
    companion object {
        const val COLUMN_NAME = UserEntity.COMPANY_PREFIX + "column_name"
    }
}

internal fun CompanyEntity.toCompany() = Company(
    bs,
    catchPhrase,
    name
)