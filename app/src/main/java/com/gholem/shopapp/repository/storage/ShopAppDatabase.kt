package com.gholem.shopapp.repository.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gholem.shopapp.repository.storage.ShopAppDatabase.Companion.DATABASE_VERSION
import com.gholem.shopapp.repository.storage.dao.TemplateDao
import com.gholem.shopapp.repository.storage.entity.TemplateEntity

@Database(
    version = DATABASE_VERSION,
    entities = [
        TemplateEntity::class,
    ]
)
abstract class ShopAppDatabase : RoomDatabase() {

    abstract fun templateDao(): TemplateDao

    companion object {

        const val DATABASE_VERSION = 1
    }
}