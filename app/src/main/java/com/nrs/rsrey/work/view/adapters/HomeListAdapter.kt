package com.nrs.rsrey.work.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nrs.rsrey.work.Model.SongListModel
import com.nrs.rsrey.work.R
import com.nrs.rsrey.work.Util.SongDiffUtil
import kotlinx.android.synthetic.main.home_list_item.view.*

class HomeListAdapter: ListAdapter<SongListModel, RecyclerView.ViewHolder>(SongDiffUtil()){

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_list_item,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data: SongListModel = getItem(position)
        (holder as MyViewHolder).title.text = data.title

        val listItemAdapter = HomeListItemAdapter()
        holder.list.apply {
           layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
            adapter = listItemAdapter
        }
        listItemAdapter.submitList(data.list)
    }

    inner class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.homeListHeading
        val list: RecyclerView = itemView.homeListListItem
    }

}