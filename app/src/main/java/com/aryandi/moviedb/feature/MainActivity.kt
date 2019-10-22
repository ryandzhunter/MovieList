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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}
