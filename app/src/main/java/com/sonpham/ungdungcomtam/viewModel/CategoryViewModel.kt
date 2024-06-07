package com.sonpham.ungdungcomtam.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sonpham.ungdungcomtam.model.Category
import com.sonpham.ungdungcomtam.responsite.Repository
import kotlinx.coroutines.launch

class CategoryViewModel(val repository: Repository): ViewModel() {

    fun addStudent(category: Category) {
        viewModelScope.launch {
            repository.addCategoryToRoom(category)
        }
    }
    val category = repository.getAllCategory()

    fun deleteStudent(category: Category) {
        viewModelScope.launch {
            repository.deleteCategoryFromRoom(category)
        }
    }

    fun updateStudent(category: Category) {
        viewModelScope.launch {
            repository.updateCategory(category)
        }
    }
}