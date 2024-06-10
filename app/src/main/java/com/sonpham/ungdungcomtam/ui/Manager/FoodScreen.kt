package com.sonpham.ungdungcomtam.ui.Manager

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.accompanist.coil.rememberCoilPainter
import com.sonpham.ungdungcomtam.R
import com.sonpham.ungdungcomtam.Screen
import com.sonpham.ungdungcomtam.model.Category
import com.sonpham.ungdungcomtam.model.Food
import com.sonpham.ungdungcomtam.ui.HeaderScreens.HeaderScreenMan
import com.sonpham.ungdungcomtam.viewModel.CategoryViewModel
import com.sonpham.ungdungcomtam.viewModel.FoodViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FoodScreen(navController: NavController,
               viewModel: CategoryViewModel,

               ){
    val context = LocalContext.current



    val food by viewModel.food.collectAsState(initial = emptyList())




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF312C2C))
    ){
        HeaderScreenMan(title = "Quản lý món ăn", goBack = {navController.popBackStack()})


//        Button(onClick = { /*TODO*/
//            add(viewModel, image =imageBytes, cate =selectedCategory.cid )
//
//
//        }) {
//            Text(text = "Thêm")
//        }

Scaffold (
    floatingActionButton = {
        FloatingActionButton(
            onClick = {
             navController.navigate(Screen.addfood.name)



            },
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.background,
            shape = CircleShape
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = null
            )
        }
    }
    
) {


    if (food.isEmpty()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize()
                .background(color = Color(0xFF312C2C))

        ) {
            Text(text = "No data")
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = Color(0xFF312C2C)),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(food) {
                Card(
                    onClick = {

//                        navController.navigate("${Screen.detail.name}/${ Uri.encode((it.cid.toString()))}/${Uri.encode(it.nameCategory)}")
                    },
                    modifier = Modifier
                        .background(color = Color(0xFF2F2D2D))
                        .fillMaxWidth()
                        ,

                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color(0xFF2F2D2D))
                            .padding(12.dp),

                        verticalAlignment = Alignment.CenterVertically


                    ) {

                        Text(
                            text = ""+ it.id,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(5.dp),
                            color = Color.White
                        )
                        val categoryId = it.categoryId // ID của category bạn muốn lấy

                        categoryId?.let { it1 -> viewModel.getCategoryById(it1) }
                        val category by viewModel.categoryById.collectAsState()


                        it.image?.let { bytes ->
                            val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                            bitmap?.let {
                                Image(
                                    bitmap = it.asImageBitmap(),
                                    contentDescription = null,
                                    modifier = Modifier.size(90.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }

                      Column {
                          Text(
                              text = "Tên món ăn : " + it.nameFood,
                              fontSize = 16.sp,
                              modifier = Modifier.padding(5.dp),
                              color = Color.White
                          )
                          if (category != null) {
                              // Hiển thị category
                              Text(text = "Loại món: " + category!!.nameCategory,
                                  color = Color.White)
                          } else {
                              // Hiển thị loading hoặc message phù hợp
                          }
                          Text(text = "Giá: " + it.price.toString()+"K",
                              color = Color.Red)

                      }
                        Icon(painter = painterResource(id = R.drawable.edit_ic), contentDescription = "edit")
                        Icon(painter = painterResource(id = R.drawable.del_ic), contentDescription = "del")



                    }


                }
            }


        }
    }
}
            






    }
}

@Composable
fun add(navController: NavController,viewModel: CategoryViewModel,
       ) {
    var name by remember {
        mutableStateOf("")
    }
    var price by remember {
        mutableStateOf("")
    }
    val categories by viewModel.category.collectAsState(initial = emptyList())
    var imageBytes by remember { mutableStateOf<ByteArray?>(null) }
    var selectedCategory by remember { mutableStateOf(categories.firstOrNull() ?: Category(0, "")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF312C2C)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        ImagePicker(
            onImageSelected = { bytes ->
                imageBytes = bytes
            }
        )
        Spacer(modifier = Modifier.height(18.dp))
        CategoryDropdown(categories = categories, selectedCategory = selectedCategory,
            onCategorySelected = { category ->
                selectedCategory = category
            })
        Spacer(modifier = Modifier.height(18.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = {
                Text(text = "Tên món ăn")
            },
            placeholder = { Text(text = "Nhập tên của món ăn") },
            colors = TextFieldDefaults.colors(
                cursorColor = Color.LightGray,

            )
        )
        Spacer(modifier = Modifier.height(18.dp))
        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            label = {
                Text(text = "Giá")
            },
            placeholder = { Text(text = "Nhập giá của món ăn") },
            colors = TextFieldDefaults.colors(
                cursorColor = Color.LightGray,

                )
        )
        Spacer(modifier = Modifier.height(28.dp))
        Button(onClick = { /*TODO*/
            viewModel.addFood(
                Food(
                    0,
                    name,
                    price.toDouble(),
                    selectedCategory.cid,
                    imageBytes
                )
            )
            navController.popBackStack()
        }) {
            Text(text = "Save")
        }
    }
}
@Composable
fun ImagePicker(
    onImageSelected: (ByteArray) -> Unit
) {
    val context = LocalContext.current
    var imageUri by remember { mutableStateOf<Uri?>(null) }
   

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { imageUri = it }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { launcher.launch("image/*") },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        imageUri?.let { uri ->
            Image(
                painter = rememberCoilPainter(uri),
                contentDescription = "Selected image",
                modifier = Modifier.size(200.dp)
            )
        } ?: Image(painter = painterResource(id = R.drawable.imagedefault), contentDescription ="image default",
            modifier = Modifier.size(200.dp))
    }

    LaunchedEffect(key1 = imageUri) {
        imageUri?.let { uri ->
            val inputStream = context.contentResolver.openInputStream(uri)
            val bytes = inputStream?.readBytes()
            bytes?.let { onImageSelected(it) }
        }
    }
   
}

@Composable
fun CategoryDropdown(
    categories: List<Category>,
    selectedCategory: Category,
    onCategorySelected: (Category) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded }
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(selectedCategory.nameCategory.toString())
            Icon(
                imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown ,
                contentDescription = null
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            categories.forEach { category ->
                DropdownMenuItem(
                    onClick = {
                        onCategorySelected(category)
                        expanded = false
                    },

                       text = { Text(category.nameCategory.toString())}

                )
            }
        }
    }
}