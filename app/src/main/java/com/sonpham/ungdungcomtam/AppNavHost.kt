//package com.example.ungdungcomtam
//
//import android.window.SplashScreen
//import androidx.compose.compose.composable
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHost
//import androidx.navigation.NavHostController
//import java.lang.reflect.Modifier
//
//@Composable
//fun AppNavHost(
//    modifier: Modifier = Modifier,
//    navController: NavHostController,
//    startDestination: String = NavigationItem.Login.route,
//    ... // other parameters
//) {
//    NavHost(
//        modifier = modifier,
//        navController = navController,
//        startDestination = startDestination
//    ) {
//        composable(NavigationItem.Welcome.route) {
//            SplashScreen(navController)
//        }
//        composable(NavigationItem.Login.route) {
//            LoginScreen(navController)
//        }
//    }