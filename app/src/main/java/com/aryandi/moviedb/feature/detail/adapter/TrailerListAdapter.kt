package com.aryandi.moviedb.feature.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aryandi.domain.model.VideoDomain
import com.aryandi.moviedb.R
import kotlinx.android.synthetic.main.list_item_video.view.*

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version TrailerListAdapter, v 0.1 2019-10-22 22:54 by Aryandi Putra
 */
class TrailerListAdapter(
    private val videos: MutableList<VideoDomain>,
    private val clickListener: (VideoDomain) -> Unit
) : RecyclerView.Adapter<TrailerListAdapter.TrailerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailerHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_video, parent, false)
        return TrailerHolder(view)
    }

    override fun getItemCount(): Int {
        return videos.size
    }

    override fun onBindViewHolder(holder: TrailerHolder, position: Int) {
        holder.bind(videos.get(position))
    }

    fun setVideos(videos: List<VideoDomain>) {
        this.videos.clear()
        this.videos.addAll(videos)
        notifyDataSetChanged()
    }

    inner class TrailerHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(video: VideoDomain) = with(view){
            tv_video_title.text = video.name
            view.setOnClickListener {
                clickListener(video)
            }
        }
    }
}

