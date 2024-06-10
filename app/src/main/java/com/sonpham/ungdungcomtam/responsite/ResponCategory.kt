package com.sonpham.ungdungcomtam.responsite

import com.sonpham.ungdungcomtam.data.CategoryDB
import com.sonpham.ungdungcomtam.model.Category
import com.sonpham.ungdungcomtam.model.Food

class Repository(val CategoryDB: CategoryDB) {
    suspend fun addCategoryToRoom(Category: Category) {
        CategoryDB.productDao().insertCategory(Category)
    }

     fun getAllCategory() = CategoryDB.productDao().getAllCategories()

    suspend fun deleteCategoryFromRoom(Category: Category) {
        CategoryDB.productDao().deleteCategoryById(Category.cid)
    }

    suspend fun updateCategory(Category: Category) {
        CategoryDB.productDao().updateCategory(Category)
    }
    suspend fun getCategoryById(id: Int): Category? {
        return CategoryDB.productDao().getCategoryById(id)
    }

    //
    suspend fun addFoodToRoom(Food: Food) {
        CategoryDB.foodDao().insertFood(Food)
    }

    fun getAllFood() = CategoryDB.foodDao().getAllfoods()

    suspend fun deleteFoodFromRoom(Food: Food) {
        CategoryDB.foodDao().deleteFoodById(Food.id)
    }

    suspend fun updateFood(Food: Food) {
        CategoryDB.foodDao().updateFood(Food)
    }

}