package com.gholem.shopapp.repository.storage

import com.gholem.shopapp.domain.model.TemplateModel
import com.gholem.shopapp.repository.storage.dao.TemplateDao
import com.gholem.shopapp.repository.storage.entity.TemplateEntity
import javax.inject.Inject

class TemplateStorageRepositoryImpl @Inject constructor(
    private val templateDao: TemplateDao
) : TemplateStorageRepository {

    override suspend fun insertTemplateModel(templateModel: TemplateModel) =
        templateDao.insert(TemplateEntity.from(templateModel))

    override suspend fun getAll(): List<TemplateModel> =
        templateDao.getAll().map { it.toModel() }
}