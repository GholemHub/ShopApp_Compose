package com.gholem.shopapp.repository.network.dto.template

import com.gholem.shopapp.domain.model.TemplateModel

data class TemplateRequest(
    val name: String
) {

    companion object {
        fun fromModel(templateModel: TemplateModel) =
            TemplateRequest(templateModel.name)
    }
}