package com.gholem.shopapp.repository.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gholem.shopapp.repository.storage.entity.BasketEntity
import com.gholem.shopapp.repository.storage.entity.TemplateEntity

@Dao
interface BasketDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(basketEntity: BasketEntity)

    @Query("SELECT * FROM basket_table")
    suspend fun getAll(): List<BasketEntity>
}