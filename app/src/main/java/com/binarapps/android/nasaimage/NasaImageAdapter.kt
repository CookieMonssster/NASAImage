package com.binarapps.android.nasaimage

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.binarapps.android.nasanetwork.model.NasaImage
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*

class NasaImageAdapter : RecyclerView.Adapter<NasaImageViewHolder>() {

    private var itemList = emptyList<NasaImage>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NasaImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return NasaImageViewHolder(view)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: NasaImageViewHolder, position: Int) {
        holder.setData(itemList[position])
    }

    fun setList(data: List<NasaImage>?) {
        data?.let {
            itemList = it
            notifyDataSetChanged()
        }
    }
}

class NasaImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun setData(nasaImage: NasaImage) {
        itemView.listItemTitle.text = nasaImage.title
        Glide.with(itemView.context)
            .load(nasaImage.image)
            .centerCrop()
            .into(itemView.listItemImage)
    }

}