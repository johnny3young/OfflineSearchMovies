package com.young.offlinesearchmovies.data


import android.app.Application
import android.content.Context
import android.sax.RootElement
import androidx.room.Room
import com.young.offlinesearchmovies.app.MyApp
import com.young.offlinesearchmovies.data.local.MovieRoomDatabase
import com.young.offlinesearchmovies.data.local.dao.MovieDao
import com.young.offlinesearchmovies.data.remote.ApiConstants
import com.young.offlinesearchmovies.data.remote.MovieApiService
import com.young.offlinesearchmovies.data.remote.RequestInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

lateinit var movieApiService: MovieApiService
lateinit var okHttpClientBuilder: OkHttpClient.Builder
lateinit var movieDao: MovieDao

class MovieRepository {

}

fun movieRepository() {

    //Local >> Room
    val movieRoomDatabase: MovieRoomDatabase = Room.databaseBuilder(MyApp(),MovieRoomDatabase::class.java,"db_movies").build()
    movieDao = movieRoomDatabase.getMovieDao()

    //RequestInterceptor: incluir en la cabecera (URL) de la petición el TOKEN o API_KEY que autoriza al usuario
    okHttpClientBuilder.addInterceptor(RequestInterceptor())
    val cliente: OkHttpClient = okHttpClientBuilder.build()

    //Remote > Retrofit
    val retrofit: Retrofit = Retrofit.Builder().baseUrl(ApiConstants.BASE_URL)
        .client(cliente)
        .addConverterFactory(GsonConverterFactory.create()).build()
    movieApiService = retrofit.create(MovieApiService::class.java)
}