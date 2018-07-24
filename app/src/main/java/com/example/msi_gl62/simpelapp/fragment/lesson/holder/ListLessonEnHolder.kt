package com.example.msi_gl62.simpelapp.fragment.lesson.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.msi_gl62.simpelapp.extension.load
import com.example.msi_gl62.simpelapp.model.Lesson
import kotlinx.android.synthetic.main.item_theme_lesson.view.*

class ListLessonEnHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(lesson: Lesson) {
        itemView.apply {
            image_lesson.load(lesson.image)
            name_lesson.text = lesson.name
        }
    }
}