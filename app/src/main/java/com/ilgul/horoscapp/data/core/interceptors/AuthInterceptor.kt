package com.ilgul.horoscapp.data.core.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor():Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .header("Authorization", "Just a value of a interceptor")
            .build()
        return chain.proceed(request)
    }
}