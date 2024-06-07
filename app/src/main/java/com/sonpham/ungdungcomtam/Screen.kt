package com.sonpham.ungdungcomtam

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sonpham.ungdungcomtam.data.CategoryDB
import com.sonpham.ungdungcomtam.responsite.Repository

import com.sonpham.ungdungcomtam.viewModel.CategoryViewModel

enum class Screen {
    Main,
    Detail
}

@Composable
fun AppNavHost() {
    val context = LocalContext.current
    val categoryDB = CategoryDB.getIntance(context)
    val categoryRepository = Repository(categoryDB)

    val categoryViewModel = remember { CategoryViewModel(categoryRepository)}
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Main.name) {
        composable(Screen.Main.name) {
            Background(navController = navController)
        }

    }
}