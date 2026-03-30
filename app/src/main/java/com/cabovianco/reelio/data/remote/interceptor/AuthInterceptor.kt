package com.cabovianco.reelio.data.remote.interceptor

import android.util.Log
import com.cabovianco.reelio.data.remote.provider.TokenProvider
import jakarta.inject.Inject
import okhttp3.Interceptor
import okhttp3.Response

private const val TAG = "AuthInterceptor"

class AuthInterceptor @Inject constructor(
    private val tokenProvider: TokenProvider
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = tokenProvider.getToken()

        Log.d(TAG, "Token: $token")

        val request = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()

        return chain.proceed(request)
    }
}
