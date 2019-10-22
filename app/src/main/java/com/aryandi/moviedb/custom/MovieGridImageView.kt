package com.aryandi.moviedb.custom

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version MoviePosterGridImageView, v 0.1 2019-10-22 09:43 by Aryandi Putra
 */
class MovieGridImageView : AppCompatImageView {

    companion object {
        private val POSTER_WIDTH_RATIO_TO_HEIGHT = 2f / 3
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        //The height should be 33% longer than the width.
        val newMeasuredHeight = measuredWidth / POSTER_WIDTH_RATIO_TO_HEIGHT
        setMeasuredDimension(measuredWidth, newMeasuredHeight.toInt())
    }
}
