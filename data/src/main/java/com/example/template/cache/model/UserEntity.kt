package com.example.template.cache.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.template.cache.tools.BaseEntityItem
import com.example.template.model.User

@Entity(tableName = UserEntity.TABLE_NAME)
internal data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = COLUMN_ID)
    override val id: Long,
    @Embedded
    val address: AddressEntity,
    @Embedded(prefix = COMPANY_PREFIX)
    val company: CompanyEntity,
    val email: String,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
): BaseEntityItem {
    companion object {
        const val TABLE_NAME = "table_user"
        const val COLUMN_ID = "user_id"
        const val COMPANY_PREFIX = "company_"
    }
}

internal fun UserEntity.toUser() = User(
    id.toInt(),
    address.toAddress(),
    company.toCompany(),
    email,
    name,
    phone,
    username,
    website
)

internal fun List<UserEntity>.toUsers() = map { it.toUser() }