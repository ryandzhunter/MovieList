package com.aryandi.moviedb.base

import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version BaseFragment, v 0.1 2019-10-21 10:51 by Aryandi Putra
 */
abstract class BaseFragment : Fragment() {

    open fun showLoading(progressBar: ProgressBar) {
        (activity as BaseActivity).showLoading(progressBar)
    }

    open fun hideLoading(progressBar: ProgressBar) {
        (activity as BaseActivity).hideLoading(progressBar)
    }

    open fun handleError(localizedMessage: String?, rootView: View) {
        (activity as BaseActivity).showError(localizedMessage, rootView)
    }
}