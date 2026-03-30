package com.cabovianco.reelio.data.remote.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateSessionRequestDto(
    @SerialName("request_token") val requestToken: String
)
