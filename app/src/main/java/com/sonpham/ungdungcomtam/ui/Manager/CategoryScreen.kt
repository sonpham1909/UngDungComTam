package com.sonpham.ungdungcomtam.ui.Manager

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sonpham.ungdungcomtam.R
import com.sonpham.ungdungcomtam.model.Category
import com.sonpham.ungdungcomtam.ui.Home.HeaderScreen
import com.sonpham.ungdungcomtam.viewModel.CategoryViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun CategoryManger(viewModel: CategoryViewModel,navController: NavController){
    val category by viewModel.category.collectAsState(initial = emptyList())
    var showALert by remember { mutableStateOf(false) }
    var nameCategory by remember { mutableStateOf("") }
    val emty by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF312C2C))
    ) {
        HeaderScreen(title = "Quản lý loại món ăn")
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                              showALert = true



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

        ){
            if(category.isEmpty()){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                        .background(color = Color(0xFF312C2C))

                ) {
                    Text(text = "No data")
                }
            }else{
                LazyColumn(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                        .background(color = Color(0xFF312C2C)),
                    contentPadding = PaddingValues(10.dp)
                ) {
                    items(category){
                        Card(onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            elevation = CardDefaults.cardElevation(4.dp)) {
                            Column(
                                modifier = Modifier.padding(14.dp)
                            ) {
                                Text(
                                    text = "ID: " + it.cid,
                                    fontSize = 16.sp,
                                    modifier = Modifier.padding(5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Loại món ăn : " + it.nameCategory,
                                    fontSize = 16.sp,
                                    modifier = Modifier.padding(5.dp),
                                )


                            }




                        }
                    }


                }
            }




        }

        Dialog(
            showAlert = showALert,
            nameCate = nameCategory,
            onDismissRequest = { showALert=false
                               nameCategory=emty},
            onConfirm = { showALert = false
                viewModel.addStudent(
                    Category(
                        0,
                        nameCategory
                    )
                )
                nameCategory=emty
            },
            onChange = { newValue ->
                nameCategory = newValue}
        )





    }
}

@Composable
fun Dialog(
    showAlert: Boolean,
    nameCate: String,
    onDismissRequest: () -> Unit,
    onConfirm: () -> Unit,
    onChange: (String) -> Unit
) {
    if (showAlert) {
        AlertDialog(
            onDismissRequest = onDismissRequest,
            title = { Text(text = "Thêm loại món ăn") },
            text = {
                Column {
                    Text("Nhập loại món ăn:")
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = nameCate,
                        onValueChange = onChange,
                        singleLine = true,
                        placeholder = { Text("Enter text") }
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onConfirm()
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = onDismissRequest) {
                    Text("Dismiss")
                }
            }
        )
    }
}