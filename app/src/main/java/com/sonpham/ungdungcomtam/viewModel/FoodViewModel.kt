package com.sonpham.ungdungcomtam.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sonpham.ungdungcomtam.model.Category
import com.sonpham.ungdungcomtam.model.Food
import com.sonpham.ungdungcomtam.responsite.ReponFood
import com.sonpham.ungdungcomtam.responsite.Repository
import kotlinx.coroutines.launch

class FoodViewModel(val repository: ReponFood): ViewModel() {


}