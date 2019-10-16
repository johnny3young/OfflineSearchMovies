package com.young.offlinesearchmovies.ui

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.young.offlinesearchmovies.R
import com.young.offlinesearchmovies.data.local.MovieEntity
import com.young.offlinesearchmovies.data.remote.ApiConstants
import kotlinx.android.synthetic.main.fragment_movie.view.*

class MyMovieRecyclerViewAdapter(
    private val mValues: List<MovieEntity>,
    private val ctx : Context


) : RecyclerView.Adapter<MyMovieRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item = mValues[position]
        Glide.with(ctx)
            .load(ApiConstants.IMAGE_API_PREFIX + holder.item.posterPath)
            .into(holder.imageViewCover!!)
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val imageViewCover: ImageView? = itemView.image_view_cover
        lateinit var item : MovieEntity

    }
}
