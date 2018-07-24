package com.example.msi_gl62.simpelapp.fragment.home.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.msi_gl62.simpelapp.R
import com.example.msi_gl62.simpelapp.fragment.home.holder.ListTeacherHolder
import com.example.msi_gl62.simpelapp.model.Teacher

class AdapterList(private var coWork: List<Teacher>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<Teacher>) {
        coWork = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            ListTeacherHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))

    override fun getItemCount(): Int = coWork.size

    override fun getItemViewType(position: Int): Int = R.layout.item_theme_list_teacher

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = (holder as ListTeacherHolder).onBind(coWork[position])



}