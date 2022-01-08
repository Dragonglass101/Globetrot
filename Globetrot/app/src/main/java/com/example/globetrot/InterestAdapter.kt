package com.example.globetrot

import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import android.widget.Toast

class InterestAdapter(private var interestListArray: ArrayList<String>, var interestHashMap: HashMap<String, ArrayList<String>>) :
    BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return interestListArray.size
    }

    override fun getChildrenCount(p0: Int): Int {

          return  interestHashMap[interestListArray[p0]]!!.size

    }

    override fun getGroup(p0: Int): Any {
        return interestListArray[p0]
    }

    override fun getChild(p0: Int, p1: Int): String {
        return interestHashMap[interestListArray[p0]]!![p1]
    }

    override fun getGroupId(p0: Int): Long {
        return 0
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return 0
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(i: Int, b: Boolean, view: View?, viewGroup: ViewGroup?): View {
        val view: View = LayoutInflater.from(viewGroup!!.context).inflate(android.R.layout.simple_expandable_list_item_1, viewGroup, false)
        val textView: TextView = view.findViewById(android.R.id.text1)
        val interest: String = interestListArray[i]
        textView.text = interest
        textView.setBackgroundColor(R.color.purple_200)
        textView.setTypeface(null, Typeface.BOLD)
        return view
    }

    override fun getChildView(i: Int, i1: Int, b: Boolean, view: View?, viewGroup: ViewGroup?): View {
        val view: View = LayoutInflater.from(viewGroup!!.context).inflate(android.R.layout.simple_selectable_list_item, viewGroup, false)
        val textView: TextView = view.findViewById(android.R.id.text1)
        val interest: String = getChild(i, i1)
        textView.text = interest
        textView.setTypeface(null, Typeface.BOLD)
        textView.setPadding(80,0, 0, 0)
        textView.setTag(R.string.selected, "unselected")
        textView.setOnClickListener {
            Toast.makeText(viewGroup.context, interest, Toast.LENGTH_SHORT).show()
            if(textView.getTag(R.string.selected).equals("unselected")) {
                textView.setBackgroundResource(R.color.background_color)
                textView.setTag(R.string.selected, "selected")
            }
            else {
                textView.setBackgroundResource(R.color.white)
                textView.setTag(R.string.selected, "unselected")
            }

        }
        return view
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }

}
