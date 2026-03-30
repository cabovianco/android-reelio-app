package com.cabovianco.reelio.data.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateSessionResponseDto(
    val success: Boolean,
    @SerialName("session_id") val sessionId: String
)
