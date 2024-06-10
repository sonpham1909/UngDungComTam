package com.sonpham.ungdungcomtam

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sonpham.ungdungcomtam.data.CategoryDB
import com.sonpham.ungdungcomtam.responsite.Repository
import com.sonpham.ungdungcomtam.ui.Detail.DetailCategoryScreen
import com.sonpham.ungdungcomtam.ui.Home.MyBottomNavigation
import com.sonpham.ungdungcomtam.ui.Login.LoginAll
import com.sonpham.ungdungcomtam.ui.Login.SignupAll
import com.sonpham.ungdungcomtam.ui.Manager.CategoryManger
import com.sonpham.ungdungcomtam.ui.Manager.FoodScreen

import com.sonpham.ungdungcomtam.ui.Manager.ProfileScreen
import com.sonpham.ungdungcomtam.ui.Manager.add

import com.sonpham.ungdungcomtam.viewModel.CategoryViewModel
import com.sonpham.ungdungcomtam.viewModel.FoodViewModel

enum class Screen {
    Main,
    Category,
    BottomTab,
    Login,
    signup,
    manager,
    detail,
    foodmanager,
    addfood
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
        composable("${Screen.detail.name}/{cid}/{nameCategory}"){
            DetailCategoryScreen(navController = navController, viewModel = categoryViewModel ,cid = it.arguments?.getString("cid"), nameCategory = it.arguments?.getString("nameCategory")!!)
        }

        composable(Screen.foodmanager.name){
            FoodScreen(navController= navController, viewModel = categoryViewModel
            )
        }
        composable(Screen.addfood.name){
            add(navController= navController, viewModel = categoryViewModel
            )
        }



    }
}