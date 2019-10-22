package com.aryandi.moviedb.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.aryandi.domain.model.MovieDomain
import com.aryandi.moviedb.R
import com.aryandi.moviedb.base.*
import com.aryandi.moviedb.common.ext.subscribe
import com.aryandi.moviedb.feature.home.adapter.MovieGridAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version HomeFragment, v 0.1 2019-10-16 13:17 by Aryandi Putra
 */
class HomeFragment : BaseFragment() {

    val viewModel: HomeViewModel by viewModel()
    private val adapter = MovieGridAdapter(mutableListOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        subscribeToData()
        recycler_view.layoutManager = GridLayoutManager(context, 2)
        recycler_view.adapter = adapter
        viewModel.loadMovies()
    }

    private fun subscribeToData() {
        viewModel.viewState.subscribe(this, ::handleViewState)
    }

    private fun handleViewState(viewState: ViewState<List<MovieDomain>>) {
        when (viewState) {
            is Loading -> showLoading(progress_bar)
            is Success -> showMovies(viewState.data)
            is Error -> handleError(viewState.error.localizedMessage)
            is NoInternetState -> showNoInternetError()
        }
    }

    private fun handleError(localizedMessage: String?) {
        hideLoading(progress_bar)
        handleError(localizedMessage, container_home)
    }

    private fun showNoInternetError() {
        hideLoading(progress_bar)
        handleError(getString(R.string.no_internet_error_message), container_home)
    }

    private fun showMovies(movies: List<MovieDomain>) {
        hideLoading(progress_bar)
        adapter.setMovies(movies)
    }
}