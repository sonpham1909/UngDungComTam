package com.sonpham.ungdungcomtam.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sonpham.ungdungcomtam.dao.CategoryDao
import com.sonpham.ungdungcomtam.model.Category
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Database(entities = [Category::class], version = 1)
abstract class CategoryDB: RoomDatabase() {
    abstract fun productDao(): CategoryDao

    companion object {

        @Volatile
        private var INTANCE: CategoryDB? = null

        fun getIntance(context: Context): CategoryDB {
            synchronized(this) {
                var intance = INTANCE
                if (intance == null) {
                    intance = Room.databaseBuilder(
                        context.applicationContext,
                        CategoryDB::class.java,
                        "ComTam"
                    ).addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            // Thêm dữ liệu mặc định khi cơ sở dữ liệu được tạo
                            // Ví dụ:
                            CoroutineScope(Dispatchers.IO).launch {
                                val categoryDao = INTANCE?.productDao()
                                categoryDao?.insertCategory(Category(nameCategory = "Category 1"))
                                categoryDao?.insertCategory(Category(nameCategory = "Category 2"))
                                delay(2000)
                                // Truy vấn dữ liệu và cập nhật UI
                                val categories = categoryDao?.getAllCategories()
                                // Thêm các dòng dữ liệu khác tùy thuộc vào nhu cầu của bạn
                            }
                        }
                    }).build()
                }
                return intance
            }
        }
    }
}