package me.hafizdwp.kade_submission_1

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.imageResource

/**
 * @author hafizdwp
 * 29/10/2019
 **/
class MainAdapter(val items: List<LeagueData>,
                  val listener: MainActionListener) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MainItemUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var root: LinearLayout = itemView.findViewById(MainItemUI.rootId)
        var image: ImageView = itemView.findViewById(MainItemUI.imgId)
        var text: TextView = itemView.findViewById(MainItemUI.textId)

        fun bind(data: LeagueData, listener: MainActionListener) {
            itemView.apply {

                // Assign data and click listener
                image.imageResource = data.imgRes
                text.text = data.name
                root.setOnClickListener {
                    listener.onClick(data)
                }
            }
        }

    }
}