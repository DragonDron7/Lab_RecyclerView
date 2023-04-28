package com.cronocode.kotlinrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(private val images: List<Image>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private lateinit var productImageList: RecyclerView

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        productImageList = recyclerView
    }

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val img: ImageView = itemView.findViewById(R.id.image)
        private val imgTitle: TextView = itemView.findViewById(R.id.image_title)

        fun bindView(image: Image) {
            img.setImageResource(image.imageSrc)
            imgTitle.text = image.title
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.item_images, parent, false)
        //для отображения 2 картинов
        viewHolder.layoutParams.width = productImageList.measuredWidth / 2
        return ImageViewHolder(viewHolder)
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(images[position])
    }
}