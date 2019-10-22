package com.aryandi.moviedb.base

import android.view.View
import android.widget.ProgressBar
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.aryandi.moviedb.common.EMPTY_STRING
import com.aryandi.moviedb.common.ext.gone
import com.aryandi.moviedb.common.ext.snackbar
import com.aryandi.moviedb.common.ext.visible

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version BaseActivity, v 0.1 2019-10-21 10:50 by Aryandi Putra
 */
abstract class BaseActivity : AppCompatActivity() {

    fun showLoading(progressBar: ProgressBar) = progressBar.visible()

    fun hideLoading(progressBar: ProgressBar) = progressBar.gone()

    fun showError(@StringRes errorMessage: Int, rootView: View) = snackbar(errorMessage, rootView)

    fun showError(errorMessage: String?, rootView: View) = snackbar(errorMessage ?: EMPTY_STRING, rootView)
}