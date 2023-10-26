package edu.bu.projectportal

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.findNavController

class DetailFragment : Fragment(R.layout.fragment_detail) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        val projTitle = view.findViewById<TextView>(R.id.projTitle)
        val projDesc =  view.findViewById<TextView>(R.id.projDesc)
        val editProj = view.findViewById<ImageButton>(R.id.editProj)
        val projAuthors = view.findViewById<TextView>(R.id.projAuthors)
        val projLink = view.findViewById<TextView>(R.id.projLink)
        val projKeywords = view.findViewById<TextView>(R.id.projKeywords)
        val isFavorite = view.findViewById<CheckBox>(R.id.projFavorite)

        projTitle.text =  Project.project.title
        projDesc.text = Project.project.description
        projAuthors.text = Project.project.authors.joinToString(separator = ", ")
        projLink.text = Project.project.link
        projKeywords.text = Project.project.keywords.joinToString(separator = ", ")

        editProj.setOnClickListener{
            view.findNavController().
            navigate(R.id.action_detailFragment_to_editFragment)
        }

        isFavorite.setOnCheckedChangeListener { _, isChecked ->
            Project.project.isFavorite = isChecked
        }
    }
}