package com.example.notesdost.ui.theme.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.notesdost.R
import com.example.notesdost.ui.theme.model.Chapter

class CustomAdapter(
    private val chapterList: List<Chapter>,  // List of chapters
    private val context: Context             // Context (usually the activity)
) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return chapterList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return chapterList[groupPosition].topicsList.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return chapterList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return chapterList[groupPosition].topicsList[childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.chapter_item, parent, false)
        val chapterName: TextView = view.findViewById(R.id.chapterTitle)
        chapterName.text = chapterList[groupPosition].chapterName // Assuming 'chapterName' is a property of Chapter

        return view
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.topics_item, parent, false)
        val cardView: CardView = view.findViewById(R.id.topicClick)
        val topicName: TextView = view.findViewById(R.id.topicsTitle)
        topicName.text = chapterList[groupPosition].topicsList[childPosition].title // Assuming 'title' is a property of Topics

        // Proper onClick handling to open the link
        cardView.setOnClickListener {
            val link = chapterList[groupPosition].topicsList[childPosition].link // Get the link
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link)) // Create an intent to open the link
            context.startActivity(intent) // Start the activity with the intent
        }

        return view
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}
