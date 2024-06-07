package com.sonpham.ungdungcomtam

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sonpham.ungdungcomtam.ui.theme.UngDungComTamTheme

class Signup : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            UngDungComTamTheme {
                val authViewModel: AuthViewModel = AuthViewModel()
                SignupScreen(
                    onRegisterClick = { email, pass ->
                        authViewModel.register(email, pass) { success, error ->
                            if (success) {
                                // Xử lý khi đăng ký thành công
                                // Chuyển sang màn hình đăng nhập
                                val intent = Intent(this, Login::class.java)
                                Toast.makeText(this, error ?: "Đăng ký thành công", Toast.LENGTH_SHORT).show()
                                startActivity(intent)
                                finish() // Đóng màn hình đăng ký


                            } else {
                                // Xử lý khi đăng ký thất bại\
                                Toast.makeText(this, error ?: "Đăng ký thất bại", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                )





            }
        }
    }
}

@Composable
fun SignupScreen(
    onRegisterClick: (String, String) -> Unit
) {
    val context = LocalContext.current
    val intent = Intent(context, Login::class.java)

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var Repassword by remember { mutableStateOf("") }
    var registrationSuccess by remember { mutableStateOf<Boolean?>(null) }
    var registrationError by remember { mutableStateOf<String?>(null) }

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
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .size(80.dp)
            )
            Spacer(modifier = Modifier.size(15.dp))
            Text(
                text = "Đăng ký nào bạn ơi!",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.size(40.dp))
        }

        val shape = RoundedCornerShape(18.dp)

        Spacer(modifier = Modifier.size(40.dp))

        Text(text = "Email: ", fontSize = 18.sp, color = Color.White)
        Spacer(modifier = Modifier.size(10.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            shape = shape
        )

        Spacer(modifier = Modifier.size(40.dp))

        Text(text = "Password: ", fontSize = 18.sp, color = Color.White)
        Spacer(modifier = Modifier.size(10.dp))
        var isPasswordVisible by remember { mutableStateOf(false) }
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            shape = shape,
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        painter = painterResource(
                            if (isPasswordVisible) R.drawable.show_pass else R.drawable.hide_pass
                        ),
                        contentDescription = if (isPasswordVisible) "Hide password" else "Show password"
                    )
                }
            }
        )

        Spacer(modifier = Modifier.size(40.dp))

        Text(text = "Confirm Password: ", fontSize = 18.sp, color = Color.White)
        Spacer(modifier = Modifier.size(10.dp))
        var isRePasswordVisible by remember { mutableStateOf(false) }
        TextField(
            value = Repassword,
            onValueChange = { Repassword = it },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            shape = shape,
            visualTransformation = if (isRePasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { isRePasswordVisible = !isRePasswordVisible }) {
                    Icon(
                        painter = painterResource(
                            if (isRePasswordVisible) R.drawable.show_pass else R.drawable.hide_pass
                        ),
                        contentDescription = if (isRePasswordVisible) "Hide password" else "Show password"
                    )
                }
            }
        )

        Spacer(modifier = Modifier.size(20.dp))

        Button(
            onClick = {
              if(email.trim().isEmpty()||password.trim().isEmpty()||Repassword.trim().isEmpty()){
                  Toast.makeText(context,"Không bỏ trống",Toast.LENGTH_SHORT).show()

              }else{
                  if (password == Repassword) {
                      if(!isValidEmail(email)){
                          Toast.makeText(context,"Email không đúng định dạng",Toast.LENGTH_SHORT).show()
                      }else {
                          onRegisterClick(email, password)
                      }
                  } else {
                      Toast.makeText(context,"Mật khẩu không giống nhau",Toast.LENGTH_SHORT).show()
                  }
              }
            },
            modifier = Modifier
                .width(150.dp)
                .height(50.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
        ) {
            Text(text = "Đăng ký")
        }

        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = "Quay lại",
            fontSize = 20.sp,
            color = Color.Yellow,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    context.startActivity(intent)
                },
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )


        }
    }

fun isValidEmail(email: String): Boolean {
    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    return email.matches(emailPattern.toRegex())
}




