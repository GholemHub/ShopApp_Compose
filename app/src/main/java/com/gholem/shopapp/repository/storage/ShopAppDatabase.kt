package com.gholem.shopapp.repository.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gholem.shopapp.repository.storage.ShopAppDatabase.Companion.DATABASE_VERSION
import com.gholem.shopapp.repository.storage.dao.BasketDao
import com.gholem.shopapp.repository.storage.dao.TemplateDao
import com.gholem.shopapp.repository.storage.entity.BasketEntity
import com.gholem.shopapp.repository.storage.entity.TemplateEntity

@Database(
    version = DATABASE_VERSION,
    entities = [
        TemplateEntity::class,
        BasketEntity::class
    ]
)
abstract class ShopAppDatabase : RoomDatabase() {

    abstract fun templateDao(): TemplateDao
    abstract fun basketDao(): BasketDao

    companion object {

        const val DATABASE_VERSION = 1
    }
}