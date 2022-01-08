package com.example.globetrot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


class Interest : Fragment() {

    private var interestListArray = ArrayList<String>()
    var interestHashMap = HashMap<String, ArrayList<String>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_interest, container, false)
        val expandableListView: ExpandableListView = view.findViewById(R.id.interest_list)
        for (i in 1..20) {
            interestListArray.add("Interest $i")
            val interestSubListArray = ArrayList<String>()
            for (j in 1..10) {
                interestSubListArray.add("SubInterest $j")
            }
            interestHashMap[interestListArray[i-1]] = interestSubListArray
        }
        val adapter: InterestAdapter = InterestAdapter(interestListArray, interestHashMap)
        expandableListView.setAdapter(adapter)
        return view
    }
}



