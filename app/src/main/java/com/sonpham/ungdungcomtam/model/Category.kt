package com.sonpham.ungdungcomtam.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "category")
data class Category (
    @PrimaryKey(autoGenerate = true) var cid: Int = 0,
    @ColumnInfo(name = "nameCategory") var nameCategory: String?
    )

