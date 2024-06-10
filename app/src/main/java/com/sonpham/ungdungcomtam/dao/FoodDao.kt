package com.sonpham.ungdungcomtam.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sonpham.ungdungcomtam.model.Category
import com.sonpham.ungdungcomtam.model.Food
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    @Query("SELECT * FROM foods")
    fun getAllfoods(): Flow<List<Food>>

    @Query("SELECT * FROM foods WHERE id = :id")
    suspend fun getFooodById(id: Int): Food?

    @Insert
    suspend fun insertFood(foods: Food)

    @Update
    suspend fun updateFood(foods: Food)

    @Query("DELETE FROM foods WHERE id = :id")
    suspend fun deleteFoodById(id: Int)
}
