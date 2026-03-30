package com.cabovianco.reelio.data.remote.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieRequestDto(
    @SerialName("media_id") val mediaId: Int
)
