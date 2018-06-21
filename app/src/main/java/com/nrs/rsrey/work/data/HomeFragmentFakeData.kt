package com.nrs.rsrey.work.data

import com.nrs.rsrey.work.Model.SongListModel
import com.nrs.rsrey.work.Model.SongModel

class HomeFragmentFakeData{

    companion object {

        private fun getFakeData(): List<SongModel>{
            val list = mutableListOf<SongModel>()
            for(i in 0..10) list.add(SongModel("https://placeimg.com/144/144/any","Song$i","Name$i"))
            return list
        }

        val HomeList: List<SongListModel>  = listOf(
                SongListModel("NEW & TRENDING", getFakeData()),
                SongListModel("RECOMMENDED FOR YOU", getFakeData()))
    }


}
