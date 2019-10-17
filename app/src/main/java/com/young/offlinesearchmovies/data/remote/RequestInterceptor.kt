package com.young.offlinesearchmovies.data.remote

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        //Las request son peticiones al servidor
        val originalRequest: Request = chain.request()

        //Tomamos la url através de un objeto url para poderlo concatenar
        val originalHttpUrl: HttpUrl = originalRequest.url()

        //Se crea la nueva URL
        val url: HttpUrl = originalHttpUrl.newBuilder().addQueryParameter("api_key", ApiConstants.API_KEY).build()

        //Se crea el nuevo Request con la nueva url añadida
        val request: Request = originalRequest.newBuilder().url(url).build()

        //Le decimos a la cadena que interceptamos que continue con el nuevo request
        return chain.proceed(request)
    }
}