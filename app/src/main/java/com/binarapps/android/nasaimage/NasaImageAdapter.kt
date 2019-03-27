package com.binarapps.android.nasaimage

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.binarapps.android.nasanetwork.model.NasaImage
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.android.synthetic.main.list_view.view.*

class NasaImageAdapter : RecyclerView.Adapter<NasaimageViewHolder>() {

    var item: List<NasaImage> = emptyList()
    private lateinit var context: Context

    fun setContext(context: Context) {
        this.context = context
    }

    fun setData(list: List<NasaImage>) {
        item = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NasaimageViewHolder {
        val inflante = LayoutInflater.from(p0.context)
        val view = inflante.inflate(R.layout.list_view, p0, false)
        return NasaimageViewHolder(view)
    }

    override fun getItemCount(): Int = item.size


    override fun onBindViewHolder(p0: NasaimageViewHolder, p1: Int) {
        p0.setNasaImage(item[p1])
        p0.iRecycleOnClick = object : IRecycleOnClick {
            override fun onClick(v: View, position: Int) {
                val nasaImageJson = Gson().toJson(item[position])
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("image", nasaImageJson)
                context.startActivity(intent)
            }
        }
    }

}

class NasaimageViewHolder(view : View) : RecyclerView.ViewHolder(view), View.OnClickListener{

    override fun onClick(v: View?) {
        if (v != null) {
            iRecycleOnClick?.onClick(v, adapterPosition)
        }
    }

    var iRecycleOnClick : IRecycleOnClick? = null


    fun setNasaImage(nasaImage: NasaImage) {
        itemView.listItemTitle.text = nasaImage.title
        Glide.with(itemView.context)
            .load(nasaImage.image)
            .centerCrop()
            .into(itemView.listItemImage)
        itemView.setOnClickListener(this)
    }
}