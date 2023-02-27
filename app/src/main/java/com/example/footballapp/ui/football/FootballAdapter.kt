package com.example.footballapp.ui.football

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.footballapp.data.model.Response
import com.example.footballapp.databinding.ItemResponseBinding
import com.squareup.picasso.Picasso

class FootballAdapter(
    private val footballList: MutableList<Response> = mutableListOf(),
    private val clickListener: (Response) -> Unit
) : RecyclerView.Adapter<FootballAdapter.ViewHolder>() {

    fun updateFootballAdapter(newFootball: List<Response>){
        footballList.clear()
        footballList.addAll(newFootball)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val view: ItemResponseBinding): RecyclerView.ViewHolder(view.root){
        fun setUp(footballResponse: Response, clickListener: (Response) -> Unit){
            Picasso.get().load(footballResponse.thumbnail).into(view.ivThumbnail)
            view.tvCompetition.text = footballResponse.competition
            view.tvTitle.text = footballResponse.title
            itemView.setOnClickListener { clickListener(footballResponse) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemResponseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = footballList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setUp(footballList[position], clickListener)
    }
}