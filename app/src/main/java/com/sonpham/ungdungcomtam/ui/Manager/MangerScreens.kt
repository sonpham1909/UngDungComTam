package com.sonpham.ungdungcomtam.ui.Manager

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sonpham.ungdungcomtam.R
import com.sonpham.ungdungcomtam.Screen
import com.sonpham.ungdungcomtam.ui.Home.HeaderScreen



@Composable
fun ManagerScreens(){

}
@Composable
fun ProfileScreen(navController: NavController) {
    // Nội dung của màn hình profile
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF312C2C))
            .clickable {
                navController.navigate(Screen.Category.name)
            }

    ) {

        HeaderScreen(title = "Quản lý")
        Spacer(modifier = Modifier.size(20.dp))
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()


                    .padding(5.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logohead),
                        contentDescription = "Logo",
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = "Quản lý loại món ăn",
                        fontSize = 20.sp,
                        color = Color.White
                    )

                }
            }
            //quản lý món ăn

            Box(
                modifier = Modifier
                    .fillMaxWidth()


                    .padding(5.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logohead),
                        contentDescription = "Logo",
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = "Quản lý món ăn",
                        fontSize = 20.sp,
                        color = Color.White
                    )

                }
            }

        }
    }
}