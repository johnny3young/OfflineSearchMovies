package com.young.offlinesearchmovies.data.remote

import com.young.offlinesearchmovies.data.remote.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface MovieApiService {
    @GET("movie/popular")
    fun loadPopularMovies(@Url url: String): retrofit2.Call<MoviesResponse>
}