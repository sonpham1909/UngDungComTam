package com.sonpham.ungdungcomtam

enum class Screen{
    Welcome,
    Login
}

sealed class NavigationItem(val route: String){
    object Welcome : NavigationItem(Screen.Welcome.name)
    object Login : NavigationItem(Screen.Login.name)
}