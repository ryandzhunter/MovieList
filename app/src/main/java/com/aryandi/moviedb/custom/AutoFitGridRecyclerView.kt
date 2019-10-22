package com.aryandi.moviedb.custom

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version AutoFitRecyclerView, v 0.1 2019-10-17 16:57 by Aryandi Putra
 */
class AutoFitGridRecyclerView : RecyclerView {
    private var manager: GridLayoutManager? = null
    private var columnWidth = -1

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        if (attrs != null) {
            val attrsArray = intArrayOf(android.R.attr.columnWidth)
            val array = context.obtainStyledAttributes(attrs, attrsArray)
            columnWidth = array.getDimensionPixelSize(0, -1)
            array.recycle()
        }

        manager = GridLayoutManager(context, 1)
        layoutManager = manager
    }

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        super.onMeasure(widthSpec, heightSpec)

        if (columnWidth > 0) {
            val spanCount = Math.max(1, measuredWidth / columnWidth)
            manager!!.spanCount = spanCount
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        return super.dispatchTouchEvent(ev)
    }
}
