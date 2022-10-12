package com.gholem.shopapp.repository.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gholem.shopapp.repository.storage.entity.TemplateEntity

@Dao
interface TemplateDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(templateEntity: TemplateEntity)

    @Query("SELECT * FROM template_table")
    suspend fun getAll(): List<TemplateEntity>
}