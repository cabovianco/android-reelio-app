package com.cabovianco.reelio.data.remote.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class ListDetailsResponseDto(
    val id: Int,
    val name: String,
    val items: List<MovieResponseDto>
)
