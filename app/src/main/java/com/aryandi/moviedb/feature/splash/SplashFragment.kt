package com.aryandi.moviedb.feature.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aryandi.moviedb.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version SplashFragment, v 0.1 2019-10-16 17:00 by Aryandi Putra
 */
class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        GlobalScope.launch {
            delay(1000L)
            findNavController().navigate(R.id.action_splash_to_home)
        }
    }
}