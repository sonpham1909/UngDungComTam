package com.sonpham.ungdungcomtam.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sonpham.ungdungcomtam.model.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Query("SELECT * FROM category")
     fun getAllCategories(): Flow<List<Category>>

    @Query("SELECT * FROM category WHERE cid = :id")
    suspend fun getCategoryById(id: Int): Category?

    @Insert
    suspend fun insertCategory(category: Category)

    @Update
    suspend fun updateCategory(category: Category)

    @Query("DELETE FROM category WHERE cid = :id")
    suspend fun deleteCategoryById(id: Int)
}
