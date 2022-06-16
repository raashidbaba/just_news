package com.example.newsbook
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

//adapter needs data so we will get data through a constructor
class NewsListAdapter(private val listener: NewsItemClicked): RecyclerView.Adapter<NewsViewHolder>() {
    private val items : ArrayList<News > = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener {
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }
    // determines total number of items inside the recycler view
    override fun getItemCount(): Int {
        return items.size
    }
    //onBindViewHolder binds data inside our holder
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        //this provides position to the items
        val currentItem = items[position]
        holder.titleView.text = currentItem.title
    }
    fun updatedNews(updatedNews:ArrayList<News>){
        items.clear()
        items.addAll(updatedNews)

        notifyDataSetChanged()
    }
}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView: TextView = itemView.findViewById(R.id.textView)
}
interface NewsItemClicked{
    fun onItemClicked(item: News)
}