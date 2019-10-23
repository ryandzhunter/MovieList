package com.aryandi.moviedb.feature.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.aryandi.domain.model.MovieDetailDomain
import com.aryandi.domain.model.VideoDomain
import com.aryandi.moviedb.R
import com.aryandi.moviedb.base.*
import com.aryandi.moviedb.common.ext.subscribe
import com.aryandi.moviedb.feature.detail.adapter.TrailerListAdapter
import com.aryandi.moviedb.feature.home.adapter.MovieGridAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import kotlinx.android.synthetic.main.fragment_movie_detail.progress_bar
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version MovieDetailFragment, v 0.1 2019-10-22 10:08 by Aryandi Putra
 */
class MovieDetailFragment : BaseFragment() {

    val viewModel: MovieDetailViewModel by viewModel()
    val args: MovieDetailFragmentArgs by navArgs()
    val adapter = TrailerListAdapter(mutableListOf()) { doOnClickAdapter(it) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        subscribeToData()
        rv_video_trailer.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        rv_video_trailer.adapter = adapter
        viewModel.getMovieDetail(args.movieId)
    }

    private fun doOnClickAdapter(video: VideoDomain) {
        video.key?.let { playVideo(it) }
    }

    fun playVideo(key: String) {
        var intent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$key"))
        // Check if the youtube app exists on the device
        if (activity?.getPackageManager()?.let { intent.resolveActivity(it) } == null) {
            // If the youtube app doesn't exist, then use the browser
            intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=$key")
            )
        }
        startActivity(intent)
    }

    private fun subscribeToData() {
        viewModel.viewState.subscribe(this, ::handleViewState)
    }

    private fun handleViewState(viewState: ViewState<MovieDetailDomain>) {
        when (viewState) {
            is Loading -> showLoading(progress_bar)
            is Success -> showMovieDetail(viewState.data)
            is Error -> handleError(viewState.error.localizedMessage)
            is NoInternetState -> showNoInternetError()
        }
    }

    private fun handleError(localizedMessage: String?) {
        hideLoading(progress_bar)
        handleError(localizedMessage, container_detail)
    }

    private fun showNoInternetError() {
        hideLoading(progress_bar)
        handleError(getString(R.string.no_internet_error_message), container_detail)
    }

    private fun showMovieDetail(data: MovieDetailDomain) {
        hideLoading(progress_bar)
        Glide.with(img_movie_poster.context).load(MovieGridAdapter.TMDB_IMAGEURL + data.posterPath)
            .into(img_movie_poster)
        tv_movie_title.text = data.originalTitle
        tv_movie_date.text = data.releaseDate
        tv_movie_duration.text = getString(R.string.minutes, data.runtime)
        tv_movie_rate.text = data.voteAverage.toString()
        tv_movie_description.text = data.overview

        data.videos?.let { adapter.setVideos(it) }
    }
}