package com.example.msi_gl62.simpelapp.fragment.home.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.msi_gl62.simpelapp.extension.load
import com.example.msi_gl62.simpelapp.model.Teacher

import kotlinx.android.synthetic.main.item_theme_list_teacher.view.*

class ListTeacherHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(teacher: Teacher) {
        itemView.apply {
            image_teacher.load(teacher.image)
            name_teacher.text = teacher.name
//            imageFood.setOnClickListener {
//                itemView.context.startActivity(Intent(itemView.context, DetailActivity::class.java)
//                    .putExtra(DetailActivity.Key, pmt))
//            }
        }
    }
}