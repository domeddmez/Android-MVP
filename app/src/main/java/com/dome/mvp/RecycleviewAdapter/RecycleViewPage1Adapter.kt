package com.dome.mvp.RecycleviewAdapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dome.mvp.R
import com.example.promptnow.testkotlin.DataModel
import kotlinx.android.synthetic.main.itemlist.view.*

/**
 * Created by PromptNow on 11/19/2018.
 */

class RecycleViewPage1Adapter(val items: DataModel, val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.itemlist,
                p0,
                false
            )
        )

    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.tvName?.text = items.categories!![p1].title
        p0.tvName?.setOnClickListener {
            listener.onClick(items.categories!![p1].title.toString())
        }
    }

    lateinit var listener: OnItemClickListener
    override fun getItemCount(): Int {
        return items.categories!!.size
    }


    interface OnItemClickListener {
        fun onClick(text: String)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }


}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val tvName = view.tvName

}

