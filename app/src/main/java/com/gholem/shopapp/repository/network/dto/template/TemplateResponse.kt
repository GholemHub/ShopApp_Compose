package com.gholem.shopapp.repository.network.dto.template

import com.gholem.shopapp.domain.model.TemplateModel

data class TemplateResponse(
    val name: String,
    val count: Int
) {

    fun toModel(): TemplateModel = TemplateModel(name, count)
}