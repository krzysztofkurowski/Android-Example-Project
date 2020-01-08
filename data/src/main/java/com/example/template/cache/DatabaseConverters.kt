package com.example.template.cache

import androidx.room.TypeConverter
import com.example.template.cache.model.AddressEntity
import com.example.template.cache.model.CompanyEntity
import com.example.template.cache.model.GeoEntity
import com.squareup.moshi.Moshi

internal class DatabaseConverters {

    @TypeConverter
    fun encodeAddress(address: AddressEntity) =
        Moshi.Builder().build().adapter(AddressEntity::class.java).toJson(address)

    @TypeConverter
    fun decodeAddress(addressEntityString: String) =
        Moshi.Builder().build().adapter(AddressEntity::class.java).fromJson(addressEntityString)!!

    @TypeConverter
    fun encodeCompany(company: CompanyEntity) =
        Moshi.Builder().build().adapter(CompanyEntity::class.java).toJson(company)

    @TypeConverter
    fun decodeCompany(companyEntityString: String) =
        Moshi.Builder().build().adapter(CompanyEntity::class.java).fromJson(companyEntityString)!!

    @TypeConverter
    fun encodeGeo(geo: GeoEntity) =
        Moshi.Builder().build().adapter(GeoEntity::class.java).toJson(geo)

    @TypeConverter
    fun decodeGeo(geoEntityString: String) =
        Moshi.Builder().build().adapter(GeoEntity::class.java).fromJson(geoEntityString)!!
}