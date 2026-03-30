package com.cabovianco.reelio.data.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateListResponseDto(
    val success: Boolean,
    @SerialName("list_id") val listId: Int
)
