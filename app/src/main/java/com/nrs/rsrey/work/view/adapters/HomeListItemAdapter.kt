package com.nrs.rsrey.work.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.nrs.rsrey.work.Model.SongModel
import com.nrs.rsrey.work.R
import com.nrs.rsrey.work.Util.SongItemDiffUtil
import kotlinx.android.synthetic.main.home_list_single_item.view.*

class HomeListItemAdapter: ListAdapter<SongModel,RecyclerView.ViewHolder>(SongItemDiffUtil()){

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.home_list_single_item,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data: SongModel = getItem(position)
        (holder as MyViewHolder).name.text = data.name
        holder.artist.text = data.other
        Glide.with(context).load(data.imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(RequestOptions().placeholder(R.drawable.circle).error(R.drawable.circle))
                .into(holder.image)
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.homeListSingleImage
        val name: TextView = itemView.homeListSingleName
        val artist: TextView = itemView.homeListSingleArtist
    }
}