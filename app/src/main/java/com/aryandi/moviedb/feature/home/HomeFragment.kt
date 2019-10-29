package com.aryandi.moviedb.feature.home

import android.os.Bundle
import android.view.*
import androidx.navigation.fragment.findNavController
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
    private val adapter = MovieGridAdapter(mutableListOf()) { doOnClickAdapter(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true);
        viewModel.loadMovies()
    }

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
    }

    private fun doOnClickAdapter(movie: MovieDomain) {
        movie.id?.let {
            val actionHomeToDetail = HomeFragmentDirections.actionHomeToDetail(it)
            findNavController().navigate(actionHomeToDetail)
        }
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_popular -> {
                viewModel.loadTopRatedMovies()
                return true
            }
            R.id.action_top_rated -> {
                viewModel.loadPopularMovies()
                return true
            }
            R.id.action_favorites -> {
                viewModel.loadFavoriteMovies()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}