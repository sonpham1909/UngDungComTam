package com.sonpham.ungdungcomtam.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foods")
data class Food(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "nameFood") var nameFood: String?,
    @ColumnInfo(name = "price") var price: Double?,
    @ColumnInfo(name = "categoryId") var categoryId: Int?,
    @ColumnInfo(name = "image") var image: ByteArray?

)
