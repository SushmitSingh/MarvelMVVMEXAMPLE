package com.example.task1marvel.ui.main

import android.app.ActionBar
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.task1marvel.data.Marvel
import com.example.task1marvel.databinding.HeroPopupWindowBinding
import com.example.task1marvel.databinding.ListItemMarvelBinding

class MarvelAdapter : RecyclerView.Adapter<MarvelAdapter.MarvelViewHolder>() {

    private var marvelList = mutableListOf<Marvel>()

    fun setMarvelList(marvelList: List<Marvel>) {
        this.marvelList.clear()
        this.marvelList.addAll(marvelList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelViewHolder {
        val binding =
            ListItemMarvelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MarvelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MarvelViewHolder, position: Int) {
        holder.bind(marvelList[position])
    }

    override fun getItemCount() = marvelList.size

    inner class MarvelViewHolder(private val binding: ListItemMarvelBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val popupBinding =
            HeroPopupWindowBinding.inflate(LayoutInflater.from(binding.root.context))

        fun bind(marvel: Marvel) {
            binding.tvTeam.text = "Team: ${marvel.team}"
            binding.tvName.text = marvel.name
            binding.tvRealName.text = marvel.realname
            binding.ivHero.clipToOutline = true // optional, sets rounded corners for image view

            Glide.with(binding.ivHero.context).load(marvel.imageurl).into(binding.ivHero)

            //Create A Popup Window For Showing The Details Of The Hero
            binding.root.setOnClickListener {
                popupBinding.tvName.text = marvel.name
                popupBinding.tvRealName.text = marvel.realname
                popupBinding.tvTeam.text = "Team: ${marvel.team}"
                popupBinding.tvFirstAppearance.text = "First Appearance: ${marvel.firstappearance}"
                popupBinding.tvCreatedBy.text = "Created By: ${marvel.createdby}"
                popupBinding.tvPublisher.text = "Publisher: ${marvel.publisher}"
                popupBinding.tvBio.text = marvel.bio
                popupBinding.ivHero.clipToOutline =
                    true // optional, sets rounded corners for image view
                Glide.with(popupBinding.ivHero.context).load(marvel.imageurl)
                    .into(popupBinding.ivHero)
                val popup = PopupWindow(binding.root.context)
                popup.contentView = popupBinding.root
                popup.isFocusable = true
                popup.width = ActionBar.LayoutParams.MATCH_PARENT
                popup.height = ActionBar.LayoutParams.MATCH_PARENT
                popup.showAsDropDown(binding.root)
            }
        }
    }

}

