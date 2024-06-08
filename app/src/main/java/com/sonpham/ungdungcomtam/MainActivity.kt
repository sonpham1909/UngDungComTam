package com.sonpham.ungdungcomtam

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sonpham.ungdungcomtam.ui.Login.Login
import com.sonpham.ungdungcomtam.ui.theme.UngDungComTamTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UngDungComTamTheme {
                AppNavHost()


            }
        }
    }
}



@Composable
fun Background(navController: NavHostController){

    val context = LocalContext.current



    LaunchedEffect(key1 = true) {
        delay(3000)
       navController.navigate(Screen.Login.name){
           popUpTo(Screen.Main.name){inclusive=true}
       }

        
    }


    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF282222))


        ){
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo", modifier = Modifier
            .size(250.dp)
            .align(Alignment.Center),
            )

    }


}