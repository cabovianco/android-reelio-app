package com.cabovianco.reelio.data.remote.provider

import com.cabovianco.reelio.data.repository.AuthRepository
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TokenProvider @Inject constructor(
    private val repository: AuthRepository
) {
    private var token: String? = null

    init {
        CoroutineScope(Dispatchers.IO).launch {
            repository.authToken.collect {
                token = it
            }
        }
    }

    fun getToken(): String = token ?: ""
}
