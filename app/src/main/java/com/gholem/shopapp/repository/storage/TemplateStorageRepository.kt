package com.gholem.shopapp.repository.storage

import com.gholem.shopapp.domain.model.TemplateModel

interface TemplateStorageRepository {

    suspend fun insertTemplateModel(templateModel: TemplateModel)

    suspend fun getAll(): List<TemplateModel>
}