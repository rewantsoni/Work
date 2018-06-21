package com.nrs.rsrey.work.Util

import androidx.recyclerview.widget.DiffUtil
import com.nrs.rsrey.work.Model.SongListModel

class SongDiffUtil: DiffUtil.ItemCallback<SongListModel>(){

    override fun areItemsTheSame(oldItem: SongListModel, newItem: SongListModel): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: SongListModel, newItem: SongListModel): Boolean {
        return false
    }

}