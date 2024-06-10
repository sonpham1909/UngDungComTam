package com.sonpham.ungdungcomtam.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sonpham.ungdungcomtam.model.Category
import com.sonpham.ungdungcomtam.model.Food
import com.sonpham.ungdungcomtam.responsite.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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
    fun addFood(food: Food) {
        viewModelScope.launch {
            repository.addFoodToRoom(food)
        }
    }
    val food = repository.getAllFood()

    fun deleteFood(food: Food) {
        viewModelScope.launch {
            repository.deleteFoodFromRoom(food)
        }
    }

    private val _categoryById = MutableStateFlow<Category?>(null)
    val categoryById: StateFlow<Category?> get() = _categoryById

    fun getCategoryById(id: Int) {
        viewModelScope.launch {
            val category = repository.getCategoryById(id)
            _categoryById.value = category
        }
    }

    fun updateFood(food: Food) {
        viewModelScope.launch {
            repository.updateFood(food)
        }
    }
}