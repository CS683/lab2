package edu.bu.projectportal

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation
import androidx.navigation.findNavController

class EditFragment : Fragment() {

    private lateinit var projTitle: EditText
    private lateinit var projDesc: EditText
    private lateinit var projAuthors: EditText
    private lateinit var projLink: EditText
    private lateinit var projKeywords: EditText
    private lateinit var submit:Button
    private lateinit var cancel:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        projTitle = view.findViewById(R.id.projTitleEdit)
        projDesc =  view.findViewById(R.id.projDescEdit)
        projAuthors = view.findViewById(R.id.projAuthorsEdit)
        projLink = view.findViewById(R.id.projLinkEdit)
        projKeywords = view.findViewById(R.id.projKeywordsEdit)

        submit = view.findViewById<Button>(R.id.submit)
        cancel = view.findViewById<Button>(R.id.cancel)

        projTitle.setText(Project.project.title)
        projDesc.setText(Project.project.description)
        projAuthors.setText(Project.project.authors.joinToString(separator = ", "))
        projLink.setText(Project.project.link)
        projKeywords.setText(Project.project.keywords.joinToString(separator = ", "))

        submit.setOnClickListener {
            Project.project.title = projTitle.text.toString()
            Project.project.description = projDesc.text.toString()
            Project.project.authors = projAuthors.text.split(",").map { it.trim() }
            Project.project.link = projLink.text.toString()
            Project.project.keywords = projKeywords.text.split(",").map { it.trim() }.toSet()
            view.findNavController().
            navigate(R.id.action_editFragment_pop)
        }
        cancel.setOnClickListener {
            view.findNavController().
            navigate(R.id.action_editFragment_pop)
        }
    }
}