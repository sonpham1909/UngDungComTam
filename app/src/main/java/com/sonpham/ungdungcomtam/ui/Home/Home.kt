package com.sonpham.ungdungcomtam.ui.Home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.sonpham.ungdungcomtam.R
import com.sonpham.ungdungcomtam.ui.Manager.ProfileScreen
import com.sonpham.ungdungcomtam.ui.theme.UngDungComTamTheme



@Composable
fun MyBottomNavigation(navController: NavController) {
    // Giữ trạng thái của tab hiện tại
    val (currentTab, setCurrentTab) = remember { mutableStateOf(0) }

    // Danh sách các tab và icon tương ứng
    val tabs = listOf(
        TabItem("Tran chủ", painterResource(id = R.drawable.ic_home)),
        TabItem("Thống kê",painterResource(id = R.drawable.ic_buy)),
        TabItem("quản lý", painterResource(id = R.drawable.ic_tag)),
        TabItem("Hỗ trợ", painterResource(id = R.drawable.ic_user))
    )

    Column(modifier = Modifier.fillMaxSize()) {

        // Nội dung của mỗi tab ứng với index
        Box(modifier = Modifier.weight(1f)) {
            when (currentTab) {
                0 -> HomeScreen()
                1 -> HomeScreen()
                2 -> ProfileScreen(navController = navController)
                3 -> FavoritesScreen()

            }
        }


        // Bottom navigation
        NavigationBar(containerColor = Color(0xFF312C2C)) {
            tabs.forEachIndexed { index, tab ->
                NavigationBarItem(
                    icon = { Image(painter = tab.icon, contentDescription = null, modifier = Modifier.size(24.dp) ) },
                    label = { Text(tab.title) },
                    selected = currentTab == index,
                    onClick = { setCurrentTab(index) }
                )
            }
        }
    }
}

// Mô hình dữ liệu cho mỗi tab
data class TabItem(val title: String, val icon: Painter)

// Định nghĩa các màn hình

@Composable
fun HeaderScreen(title:String){
   Column {
       Box(modifier = Modifier
           .fillMaxWidth()

           .background(color = Color(0xFF312C2C))
           .padding(10.dp)){
           Row(
               horizontalArrangement = Arrangement.Center,
               verticalAlignment = Alignment.CenterVertically
           ) {
               Image(painter = painterResource(id = R.drawable.logohead), contentDescription ="Logo" )
               Spacer(modifier = Modifier.size(10.dp))
               Text(text = title,
                   fontSize = 20.sp,
                   color = Color.White)

           }
       }
       Box(modifier = Modifier
           .fillMaxWidth()
           .height(5.dp)
           .background(color = Color.Black))

   }

}

@Composable
fun HomeScreen() {
    // Nội dung của màn hình home
   Column(
       modifier = Modifier
           .fillMaxSize()
           .background(color = Color(0xFF312C2C))
   ) {

       HeaderScreen(title = "Trang chủ")
       Spacer(modifier = Modifier.size(20.dp))

       Text(text = "Today: 19 - 05 - 2023",
           fontSize = 18.sp,
           fontWeight = FontWeight.Bold,
           color = Color.White,
           modifier =  Modifier.align(Alignment.CenterHorizontally)
       )
       Text(text = "Số lượng đơn: 2",
           fontSize = 18.sp,
           fontWeight = FontWeight.Bold,
           color = Color.White,
           modifier =  Modifier.align(Alignment.CenterHorizontally)
       )
       Row (
           modifier = Modifier.align(Alignment.CenterHorizontally)
       ){
           Text(text = "Doanh Thu: ",
               fontSize = 18.sp,
               fontWeight = FontWeight.Bold,
               color = Color.White,

           )
           Text(text = "320000 k",
               fontSize = 18.sp,
               fontWeight = FontWeight.Bold,
               color = Color.Red,

           )
       }
       Spacer(modifier = Modifier.size(20.dp))
       Card(
           modifier = Modifier
               .background(color = Color(0xFF2F2D2D))
               .fillMaxWidth()
               .padding(8.dp)
       ){
           Column (
               modifier = Modifier
                   .background(color = Color(0xFF2F2D2D))
                   .fillMaxWidth()
                   .padding(8.dp)
           ){
              Row {
                  Text(text = "Đơn hàng CT235235",
                      fontSize = 15.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color.White,

                      )
                  Spacer(modifier = Modifier.size(32.dp))
                  Text(text = "||",
                      fontSize = 20.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color.White,

                      )
                  Spacer(modifier = Modifier.size(32.dp))
                  Text(text = "130000 K",
                      fontSize = 15.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color.White,

                      )
              }
               Spacer(modifier = Modifier.size(12.dp))
              Row{
                  Text(text = "Trạng thái",
                      fontSize = 15.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color.White,

                      )
                  Spacer(modifier = Modifier.width(170.dp))
                  Text(text = "Từ chối",
                      fontSize = 15.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color.Red

                  )
              }
           }


       }
       Card(
           modifier = Modifier
               .background(color = Color(0xFF2F2D2D))
               .fillMaxWidth()
               .padding(8.dp)
       ){
           Column (
               modifier = Modifier
                   .background(color = Color(0xFF2F2D2D))
                   .fillMaxWidth()
                   .padding(8.dp)
           ){
               Row {
                   Text(text = "Đơn hàng CT235235",
                       fontSize = 15.sp,
                       fontWeight = FontWeight.Bold,
                       color = Color.White,

                       )
                   Spacer(modifier = Modifier.size(32.dp))
                   Text(text = "||",
                       fontSize = 20.sp,
                       fontWeight = FontWeight.Bold,
                       color = Color.White,

                       )
                   Spacer(modifier = Modifier.size(32.dp))
                   Text(text = "130000 K",
                       fontSize = 15.sp,
                       fontWeight = FontWeight.Bold,
                       color = Color.White,

                       )
               }
               Spacer(modifier = Modifier.size(12.dp))
               Row{
                   Text(text = "Trạng thái",
                       fontSize = 15.sp,
                       fontWeight = FontWeight.Bold,
                       color = Color.White,

                       )
                   Spacer(modifier = Modifier.width(170.dp))
                   Text(text = "Từ chối",
                       fontSize = 15.sp,
                       fontWeight = FontWeight.Bold,
                       color = Color.Red

                   )
               }
           }


       }
       Card(
           modifier = Modifier
               .background(color = Color(0xFF2F2D2D))
               .fillMaxWidth()
               .padding(8.dp)
       ){
           Column (
               modifier = Modifier
                   .background(color = Color(0xFF2F2D2D))
                   .fillMaxWidth()
                   .padding(8.dp)
           ){
               Row {
                   Text(text = "Đơn hàng CT235235",
                       fontSize = 15.sp,
                       fontWeight = FontWeight.Bold,
                       color = Color.White,

                       )
                   Spacer(modifier = Modifier.size(32.dp))
                   Text(text = "||",
                       fontSize = 20.sp,
                       fontWeight = FontWeight.Bold,
                       color = Color.White,

                       )
                   Spacer(modifier = Modifier.size(32.dp))
                   Text(text = "130000 K",
                       fontSize = 15.sp,
                       fontWeight = FontWeight.Bold,
                       color = Color.White,

                       )
               }
               Spacer(modifier = Modifier.size(12.dp))
               Row{
                   Text(text = "Trạng thái",
                       fontSize = 15.sp,
                       fontWeight = FontWeight.Bold,
                       color = Color.White,

                       )
                   Spacer(modifier = Modifier.width(170.dp))
                   Text(text = "Từ chối",
                       fontSize = 15.sp,
                       fontWeight = FontWeight.Bold,
                       color = Color.Red

                   )
               }
           }


       }

   }
}
@Preview
@Composable
fun FavoritesScreen() {
    // Nội dung của màn hình favorites
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF312C2C))
    ) {

        HeaderScreen(title = "Hỗ trợ")
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(painter = painterResource(id = R.drawable.imgzalo), contentDescription = "Zalo",
                modifier = Modifier.size(70.dp))
            Text(text = "09673534f4",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,

                )

        }

        Spacer(modifier = Modifier.size(12.dp))
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(painter = painterResource(id = R.drawable.imggmail), contentDescription = "Zalo",
                modifier = Modifier.size(70.dp))
            Text(text = "09673534f4",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,

                )

        }
        Spacer(modifier = Modifier.size(12.dp))
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(painter = painterResource(id = R.drawable.imghotline), contentDescription = "Zalo",
                modifier = Modifier.size(70.dp))
            Text(text = "09673534f4",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,

                )

        }


    }
}

@Composable
fun User(){

}


