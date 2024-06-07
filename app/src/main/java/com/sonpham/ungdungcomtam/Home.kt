package com.sonpham.ungdungcomtam

import android.media.Image
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
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sonpham.ungdungcomtam.ui.theme.UngDungComTamTheme

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UngDungComTamTheme {
                MyBottomNavigation()
            }
        }
    }
}

@Composable
fun MyBottomNavigation() {
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
                1 -> FavoritesScreen()
                2 -> ProfileScreen()
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

   }
}

@Composable
fun FavoritesScreen() {
    // Nội dung của màn hình favorites
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF312C2C))
    ) {

        HeaderScreen(title = "Thống kê")

    }
}

@Composable
fun ProfileScreen() {
    // Nội dung của màn hình profile
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF312C2C))
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
