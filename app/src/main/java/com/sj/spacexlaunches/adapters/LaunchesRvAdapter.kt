package com.sj.spacexlaunches.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.sj.spacexlaunches.R
import com.sj.spacexlaunches.model.Launch
import kotlinx.android.synthetic.main.launch_item.view.*

class LaunchesRvAdapter(private val launchesList: ArrayList<Launch>, private val context: Context) : RecyclerView.Adapter<LaunchesRvAdapter.LaunchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return LaunchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.launch_item,parent,false))
    }

    override fun getItemCount(): Int {
        return launchesList.size
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.populate(launchesList[position], context)
    }

    class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun populate(launch: Launch, context: Context){
            itemView.mission_name_tv.text = launch.launchName
            itemView.launch_date.text = launch.launchDate

            launch.launchImage?.let {
                val options: RequestOptions = RequestOptions().placeholder(R.drawable.loading_image).error(R.drawable.rocket_icon)
                Glide.with(context).load(it).apply(options).into(itemView.launch_image)
            }
        }
    }
}
