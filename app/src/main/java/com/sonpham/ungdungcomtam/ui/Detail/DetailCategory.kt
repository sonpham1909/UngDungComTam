package com.sonpham.ungdungcomtam.ui.Detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sonpham.ungdungcomtam.R
import com.sonpham.ungdungcomtam.model.Category
import com.sonpham.ungdungcomtam.viewModel.CategoryViewModel

@Composable
fun DetailCategoryScreen(navController: NavController,
                         viewModel : CategoryViewModel,

                         cid : String?,
                         nameCategory: String
){
    var showDelDialog = remember { mutableStateOf(false) }
    var showUpdateDialog = remember { mutableStateOf(false) }
    var nameInput by remember { mutableStateOf("") }
    val emty by remember { mutableStateOf("") }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(15.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Row {
                Text(
                    text = "ID: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "" + cid,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Row {
                Text(
                    text = "Loại món: ",
                    fontSize = 16.sp,
                )
                Text(
                    text = "" + nameCategory,
                    fontSize = 16.sp,
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                OutlinedIconButton(
                    onClick = { showDelDialog.value = true },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier.size(height = 50.dp, width = 100.dp)
                ) {
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.del_ic),
                            contentDescription = null
                        )
                        Text(text = "Delete")
                    }
                }
                OutlinedIconButton(
                    onClick = { showUpdateDialog.value = true
                              nameInput=nameCategory},
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier.size(height = 50.dp, width = 100.dp)
                ) {
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.edit_ic),
                            contentDescription = null
                        )
                        Text(text = "Update")
                    }
                }
            }

        }

    }
    if (showDelDialog.value) {
        AlertDialog(
            onDismissRequest = { showDelDialog.value = false },
            dismissButton = {
                Button(
                    onClick = {
                        showDelDialog.value = false
                        navController.popBackStack()
                    }
                ) {
                    Text(text = "No")
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (cid != null) {
                            viewModel.deleteStudent(
                                category = Category(
                                    cid = cid.toInt(),
                                    nameCategory = nameCategory,

                                )
                            )
                        }
                        showDelDialog.value = false
                        navController.popBackStack()
                    }
                ) {
                    Text(text = "Yes")
                }
            },
            title = {
                Text(
                    text = "Delete student",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            },
            text = {
                Text(
                    text = "Are you sure?",
                    fontSize = 25.sp
                )
            }
        )
    }

    if (showUpdateDialog.value) {
        AlertDialog(
            onDismissRequest = { showUpdateDialog.value = false },
            dismissButton = {
                Button(
                    onClick = {
                        showUpdateDialog.value = false
                       nameInput = emty

                    }
                ) {
                    Text(text = "Cancel")
                }
            },
            confirmButton = {
                if (nameInput.isNotEmpty() ) {

                    Button(
                        onClick = {
                            val newStudent = Category(cid!!.toInt(),nameInput)
                            viewModel.updateStudent(newStudent)
                            navController.popBackStack()
                            showUpdateDialog.value = false
                            nameInput = emty

                        }
                    ) {
                        Text(text = "Update")
                    }
                }
            },
            title = {
                Text(
                    text = "Update Student",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(5.dp)
                )
            },
            text = {
                Column {
                    OutlinedTextField(
                        value = nameInput,
                        onValueChange = {nameInput = it},
                        label = {
                            Text(text = "Họ Tên")
                        },
                        placeholder = { Text(text = "Nhập loại món ăn")}
                    )

                }
            }
        )
    }

}