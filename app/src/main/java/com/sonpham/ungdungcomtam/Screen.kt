package com.sonpham.ungdungcomtam

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sonpham.ungdungcomtam.data.CategoryDB
import com.sonpham.ungdungcomtam.responsite.Repository
import com.sonpham.ungdungcomtam.ui.Home.MyBottomNavigation
import com.sonpham.ungdungcomtam.ui.Login.LoginAll
import com.sonpham.ungdungcomtam.ui.Login.SignupAll
import com.sonpham.ungdungcomtam.ui.Manager.CategoryManger

import com.sonpham.ungdungcomtam.ui.Manager.ProfileScreen

import com.sonpham.ungdungcomtam.viewModel.CategoryViewModel

enum class Screen {
    Main,
    Category,
    BottomTab,
    Login,
    signup,
    manager,
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
        composable(Screen.Category.name){
            CategoryManger(viewModel = categoryViewModel,navController = navController)
        }
        composable(Screen.Login.name){
            LoginAll(navController= navController)
        }

        composable(Screen.BottomTab.name){
            MyBottomNavigation(navController = navController)
        }
        composable(Screen.signup.name){
            SignupAll(navController= navController)
        }
        composable(Screen.manager.name){
            ProfileScreen(navController= navController)
        }

    }
}