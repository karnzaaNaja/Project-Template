package com.example.msi_gl62.simpelapp.fragment.lesson.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.msi_gl62.simpelapp.R
import com.example.msi_gl62.simpelapp.fragment.lesson.holder.ListLessonMathematicsHolder
import com.example.msi_gl62.simpelapp.model.Lesson

class AdapterListMathematics(private var coWork: List<Lesson>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<Lesson>) {
        coWork = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            ListLessonMathematicsHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))

    override fun getItemCount(): Int = coWork.size

    override fun getItemViewType(position: Int): Int = R.layout.item_theme_lesson

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = (holder as ListLessonMathematicsHolder).onBind(coWork[position])



}