package com.cabovianco.reelio.data.remote.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class CreateListRequestDto(
    val name: String
)
