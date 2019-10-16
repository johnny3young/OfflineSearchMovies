package com.young.offlinesearchmovies.data


import com.young.offlinesearchmovies.data.remote.ApiConstants
import com.young.offlinesearchmovies.data.remote.MovieApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

lateinit var movieApiService: MovieApiService

class MovieRepository {

}

fun movieRepository() {
    //Remote > Retrofit
    val retrofit: Retrofit = Retrofit.Builder().baseUrl(ApiConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
    movieApiService = retrofit.create(MovieApiService::class.java)
}