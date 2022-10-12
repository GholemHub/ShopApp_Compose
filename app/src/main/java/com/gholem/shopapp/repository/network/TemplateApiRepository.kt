package com.gholem.shopapp.repository.network

import com.gholem.shopapp.domain.model.TemplateModel

interface TemplateApiRepository {

    suspend fun getTemplate(): TemplateModel

    suspend fun saveTemplate(templateModel: TemplateModel)
}