package com.sonpham.ungdungcomtam.responsite

import com.sonpham.ungdungcomtam.data.CategoryDB
import com.sonpham.ungdungcomtam.model.Category

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
}