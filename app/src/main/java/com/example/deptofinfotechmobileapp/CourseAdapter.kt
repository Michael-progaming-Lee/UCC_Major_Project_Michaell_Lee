package com.example.deptofinfotechmobileapp
// Michael Lee ID#20214626
// Iodre Paterson ID#20196143

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CourseAdapter(private val courses: List<Course>) :
    RecyclerView.Adapter<CourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_course_view_holder, parent, false)
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]

        holder.codeTextView.text = "${course.code}"
        holder.nameTextView.text = "${course.name}"
        holder.creditsTextView.text = "${course.credits}"
        holder.prerequisitesTextView.text = "${course.prerequisites}"
        holder.descriptionTextView.text = "${course.description}"
    }

    override fun getItemCount(): Int {
        return courses.size
    }
}
