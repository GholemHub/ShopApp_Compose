package com.gholem.shopapp.repository.network.fake

import com.gholem.shopapp.domain.model.TemplateModel
import com.gholem.shopapp.repository.network.TemplateApiRepository

class TemplateApiFakeRepository : TemplateApiRepository {

    override suspend fun getTemplate(): TemplateModel =
        TemplateModel("Mocked data", 1)

    override suspend fun saveTemplate(templateModel: TemplateModel) = Unit
}