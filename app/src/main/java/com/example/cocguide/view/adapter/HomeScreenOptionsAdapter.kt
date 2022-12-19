package com.example.cocguide.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.marginStart
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cocguide.R
import com.example.cocguide.databinding.HomeOptionsItemBinding
import com.example.cocguide.model.Constants.FRAGMENT_INDEX
import com.example.cocguide.view.activities.ServiceActivity
import java.lang.Math.min


class HomeScreenOptionsAdapter(private val collections : List<String>, private val imageList : List<Int>, private val context: Context) : RecyclerView.Adapter<HomeScreenOptionsAdapter.ViewHolder>(){

    companion object{
        private const val MARGIN_SIZE = 10
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = HomeOptionsItemBinding.inflate(LayoutInflater.from(context), parent, false)

        calculateImageDimen(parent, binding)

        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val collection = collections[position]

        holder.cvText.text = collection

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ServiceActivity::class.java)
            intent.putExtra(FRAGMENT_INDEX,position)
            context.startActivity(intent)
        }
        
        holder.cvMoreOptionsBtn.setOnClickListener{
            Toast.makeText(context, "More options clicked", Toast.LENGTH_SHORT).show()
        }

        Glide
            .with(context)
            .load(ContextCompat.getDrawable(context, imageList[position]))
            .fitCenter()
            .placeholder(ContextCompat.getDrawable(context, R.drawable.button_bg))
            .into(holder.cvImage)

    }

    override fun getItemCount(): Int {
        return collections.size
    }

    inner class ViewHolder(view: HomeOptionsItemBinding) : RecyclerView.ViewHolder(view.root){
        val cvText = view.cvText
        val cvImage = view.cvImage
        val cvMoreOptionsBtn = view.cvMoreOptionsBtn
    }


    private fun calculateImageDimen(parent: ViewGroup, binding: HomeOptionsItemBinding) {
        val cardImageWidth = parent.width/2 - (2*binding.llItem.marginStart)
        val cardImageHeight = parent.height/(imageList.size/2) - (2* binding.llItem.marginStart)
        val imageDimension = kotlin.math.min(cardImageWidth, cardImageHeight)
        val layoutParams = ViewGroup.LayoutParams(imageDimension, imageDimension)
        binding.cvImage.layoutParams = layoutParams
    }
}