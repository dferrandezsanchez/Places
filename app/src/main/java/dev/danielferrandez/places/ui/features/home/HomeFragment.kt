package dev.danielferrandez.places.ui.features.home

import androidx.fragment.app.Fragment
import dev.danielferrandez.places.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel : HomeViewModel by viewModel()

}