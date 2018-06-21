package com.nrs.rsrey.work.Util

import androidx.recyclerview.widget.DiffUtil
import com.nrs.rsrey.work.Model.SongModel

class SongItemDiffUtil: DiffUtil.ItemCallback<SongModel>(){

    override fun areItemsTheSame(oldItem: SongModel, newItem: SongModel): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: SongModel, newItem: SongModel): Boolean {
        return false
    }

}