package com.aryandi.moviedb.feature.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aryandi.domain.model.MovieDomain
import com.aryandi.moviedb.R
import com.aryandi.moviedb.feature.home.adapter.MovieGridAdapter.MovieHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.grid_item_movie.view.*

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version MovieGridAdapter, v 0.1 2019-10-17 14:27 by Aryandi Putra
 */
class MovieGridAdapter(
    private val movies: MutableList<MovieDomain>,
    private val clickListener: (MovieDomain) -> Unit
) :
    RecyclerView.Adapter<MovieHolder>() {

    companion object {
        const val TMDB_IMAGEURL = "https://image.tmdb.org/t/p/w500/"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.grid_item_movie, parent, false)
        return MovieHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movies.get(position))
    }

    fun setMovies(movies: List<MovieDomain>) {
        this.movies.clear()
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

    inner class MovieHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(movie: MovieDomain) = with(view) {
            if (movie.posterPath != null) {
                Glide.with(view.context).load(TMDB_IMAGEURL + movie.posterPath)
                    .into(img_movie)
            }
            view.setOnClickListener {
                clickListener(movie)
            }
        }
    }
}