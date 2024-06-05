package com.example.ungdungcomtam
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ungdungcomtam.R
import com.example.ungdungcomtam.ui.theme.UngDungComTamTheme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UngDungComTamTheme {
                LoginScreen()

            }
        }
    }
}

@Preview
@Composable
fun LoginScreen(){

    var email by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF282222))
            .padding(10.dp)

    ) {
      Column(
          modifier = Modifier
              .fillMaxWidth()
              .background(color = Color.LightGray)
      ) {
          Spacer(modifier = Modifier.size(30.dp))
          Image(painter = painterResource(id = R.drawable.logo), contentDescription ="logo",
              modifier = Modifier
                  .fillMaxWidth()
                  .align(Alignment.CenterHorizontally)
          )
          Spacer(modifier = Modifier.size(15.dp))
          Text(text = "Đăng nhập đi bạn ơi!",
              fontSize = 20.sp,
              color = Color.Black,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.align(Alignment.CenterHorizontally)
          )
          Spacer(modifier = Modifier.size(40.dp))

      }

        val shape = RoundedCornerShape(18.dp)


        Spacer(modifier = Modifier.size(40.dp))

        Text(text = "Email: ",
            fontSize = 18.sp,
            color = Color.White)
        Spacer(modifier = Modifier.size(10.dp))

        TextField(value = email, onValueChange ={ email=it},
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),

            shape = shape,



        )

        Spacer(modifier = Modifier.size(40.dp))

        Text(text = "Password: ",
            fontSize = 18.sp,
            color = Color.White)

        Spacer(modifier = Modifier.size(10.dp))

        TextField(value = password, onValueChange ={ password=it},
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),

            shape = shape,



            )
        Spacer(modifier = Modifier.size(60.dp))

        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .width(150.dp)
                .height(50.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow

            )


        ) {
            Text(text = "Đăng nhập")

        }

        Spacer(modifier = Modifier.size(20.dp))
        Text(text = "Đăng ký",
            fontSize = 20.sp,
            color = Color.Yellow,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = TextStyle(textDecoration = TextDecoration.Underline)


            )





    }

}