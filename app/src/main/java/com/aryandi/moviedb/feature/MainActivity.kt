package com.aryandi.moviedb.feature

import android.os.Bundle
import android.view.Menu
import com.aryandi.moviedb.R
import com.aryandi.moviedb.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
