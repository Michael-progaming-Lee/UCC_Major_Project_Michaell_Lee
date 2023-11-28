package com.example.deptofinfotechmobileapp
// Michael Lee ID#20214626
// Iodre Paterson ID#20196143

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val codeTextView: TextView = itemView.findViewById(R.id.codeTextView)
    val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
    val creditsTextView: TextView = itemView.findViewById(R.id.creditsTextView)
    val prerequisitesTextView: TextView = itemView.findViewById(R.id.prerequisitesTextView)
    val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
}