package com.young.offlinesearchmovies.data.remote.model

import com.young.offlinesearchmovies.data.local.MovieEntity

data class MoviesResponse (val results : List<MovieEntity>)