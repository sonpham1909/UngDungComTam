package com.sonpham.ungdungcomtam.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sonpham.ungdungcomtam.dao.CategoryDao
import com.sonpham.ungdungcomtam.dao.FoodDao
import com.sonpham.ungdungcomtam.model.Category
import com.sonpham.ungdungcomtam.model.Food
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Database(entities = [Category::class,Food::class], version = 3)
abstract class CategoryDB: RoomDatabase() {
    abstract fun productDao(): CategoryDao
    abstract fun foodDao(): FoodDao

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
                    ).
                    fallbackToDestructiveMigration().build()
                }
                return intance
            }
        }
    }
}