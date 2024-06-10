package com.sonpham.ungdungcomtam.ui.HeaderScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sonpham.ungdungcomtam.R

@Composable
fun HeaderScreenMan(title:String,goBack: ()-> Unit){
    Column {
        Box(modifier = Modifier
            .fillMaxWidth()

            .background(color = Color(0xFF312C2C))
            .padding(10.dp)){
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(id = R.drawable.backbtn), contentDescription ="goBack", modifier = Modifier.clickable { goBack() } )
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