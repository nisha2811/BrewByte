package com.example.brewbyte.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.brewbyte.R
import com.example.brewbyte.activities.ItemListActivity
import com.example.brewbyte.databinding.ViewholdercategoryBinding
import com.example.brewbyte.domain.CategoryModel

class CategoryAdapter(val items : MutableList<CategoryModel>) :
RecyclerView.Adapter<CategoryAdapter.ViewHolder>()
{
    private lateinit var context: Context
    private var selectedPosition = -1
    private var lastSelectedPosition = -1

    class ViewHolder(val binding: ViewholdercategoryBinding) :
    RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.ViewHolder
    {
        context = parent.context
        val binding = ViewholdercategoryBinding.inflate(
            LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, @SuppressLint("RecyclerView") position: Int)
    {
        val item = items[position]

        holder.binding.titleCat.text = item.title

        holder.binding.root.setOnClickListener {
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)

            Handler(Looper.getMainLooper()).postDelayed( {
                val intent = Intent(context, ItemListActivity::class.java).apply {
                    putExtra("id", item.id.toString())
                    putExtra("title", item.title)
                }
                ContextCompat.startActivity(context, intent, null)
            }, 500)
        }

        if(selectedPosition == position)
        {
            holder.binding.titleCat.setBackgroundResource(R.drawable.brown_full_corner)
            holder.binding.titleCat.setTextColor(context.resources.getColor(R.color.white))
        }
        else
        {
            holder.binding.titleCat.setBackgroundResource(R.drawable.cream_full_corner)
            holder.binding.titleCat.setTextColor(context.resources.getColor(R.color.darkBrown))
        }
    }

    override fun getItemCount(): Int = items.size
}