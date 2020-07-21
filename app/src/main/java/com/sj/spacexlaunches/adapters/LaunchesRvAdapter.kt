package com.sj.spacexlaunches.adapters

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.net.Uri
import android.text.format.DateFormat
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sj.spacexlaunches.R
import com.sj.spacexlaunches.activities.LaunchInfoActivity
import com.sj.spacexlaunches.model.launch_model.Launch
import kotlinx.android.synthetic.main.launch_item.view.*
import java.util.*

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
            itemView.mission_name.text = launch.missionName
            if(DateUtils.isToday(Date(launch.launchDateUnix*1000L).time)) {
                itemView.launch_date.text = "Today ${DateFormat.format(
                    "hh:mm aa",
                    Date(launch.launchDateUnix * 1000L).time
                )}"
                itemView.launch_date.setTextColor(Color.RED)
            }else{
                itemView.launch_date.text = Date(launch.launchDateUnix*1000L).toString()
                itemView.launch_date.setTextColor(Color.BLACK)
            }
            itemView.flight_number.text = launch.flightNumber.toString()
            val background : Drawable = itemView.flight_number.background
            when(launch.launchSuccess){
                null -> background.setTint(Color.YELLOW)
                true -> background.setTint(Color.GREEN)
                false -> background.setTint(Color.RED)
            }

            if (launch.links.flickrImages.size != 0){
                val options: RequestOptions = RequestOptions().placeholder(R.drawable.loading_image)
                    .error(R.drawable.rocket_icon)
                Glide.with(context).load(Uri.parse(launch.links.flickrImages[0])).apply(options).into(itemView.launch_image)
            }else{
                Glide.with(context).load(R.drawable.rocket_icon).into(itemView.launch_image)
            }

            itemView.setOnClickListener {
                val info: Intent = Intent(context, LaunchInfoActivity::class.java)
                info.putExtra("id", launch.flightNumber)
                context.startActivity(info)
            }
        }
    }
}
