package com.example.imagesscrol.presentation.screen.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagesscrol.R
import com.example.imagesscrol.databinding.PagerImageBinding
import com.example.imagesscrol.presentation.model.Image

class ImagePagerAdapter : ListAdapter<Image, ImagePagerAdapter.ImageViewHolder>(CategoryDiffUtil()) {

    inner class ImageViewHolder(private val binding: PagerImageBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() = with(binding) {
            val item = currentList[adapterPosition]

            tvLocation.text = item.location
            tvPrice.text = item.price
            tvTitle.text = item.title
            imgIcRate.setImageResource(R.drawable.ic_group)
            imgIcFlame.setImageResource(R.drawable.ic_flame)
            imgIcPin.setImageResource(R.drawable.ic_pin)
            Glide.with(root)
                .load(item.cover)
                .into(imgLocation)

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            PagerImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind()
    }

    class CategoryDiffUtil : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }
    }
}