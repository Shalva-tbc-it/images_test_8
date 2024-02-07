package com.example.imagesscrol.presentation.screen.home

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewpager2.widget.ViewPager2
import com.example.imagesscrol.databinding.FragmentHomeBinding
import com.example.imagesscrol.presentation.common.base.BaseFragment
import com.example.imagesscrol.presentation.event.home.HomeScreenEvent
import com.example.imagesscrol.presentation.screen.home.adapter.ImagePagerAdapter
import com.example.imagesscrol.presentation.state.ImageState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var imagePagerAdapter: ImagePagerAdapter

    override fun bind() {
        bindAdapter()
        viewModel.onEvent(HomeScreenEvent.FetchConnections)
    }

    override fun bindViewActionListeners() {

    }

    override fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.imageState.collect {
                    handleConnectionState(it)
                }
            }
        }
    }

    private fun bindAdapter() = with(binding) {
        imagePagerAdapter = ImagePagerAdapter()
        viewPager.adapter = imagePagerAdapter
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager.offscreenPageLimit = 2

    }


    private fun handleConnectionState(state: ImageState) {
        binding.loader.visibility =
            if (state.isLoading) View.VISIBLE else View.GONE

        state.connections?.let {
            imagePagerAdapter.submitList(it)
        }

        state.errorMessage?.let {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            viewModel.onEvent(HomeScreenEvent.ResetErrorMessage)
        }
    }

}