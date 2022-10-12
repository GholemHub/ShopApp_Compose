package com.gholem.shopapp.repository.network.real

import com.gholem.shopapp.domain.model.TemplateModel
import com.gholem.shopapp.repository.network.TemplateApiRepository
import com.gholem.shopapp.repository.network.api.TemplateApi
import com.gholem.shopapp.repository.network.dto.template.TemplateRequest
import javax.inject.Inject

class TemplateApiNetworkRepository @Inject constructor(
    private val templateApi: TemplateApi
) : TemplateApiRepository {

    override suspend fun getTemplate(): TemplateModel =
        templateApi.getTemplateMethod().toModel()

    override suspend fun saveTemplate(templateModel: TemplateModel) =
        templateApi.saveTemplateMethod(TemplateRequest.fromModel(templateModel))
}