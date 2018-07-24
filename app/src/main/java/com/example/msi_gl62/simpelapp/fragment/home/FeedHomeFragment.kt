package com.example.msi_gl62.simpelapp.fragment.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.msi_gl62.simpelapp.JsonMockUtility
import com.example.msi_gl62.simpelapp.R
import com.example.msi_gl62.simpelapp.fragment.home.adapter.AdapterList
import com.example.msi_gl62.simpelapp.model.ListTeacher
import kotlinx.android.synthetic.main.fragment_feed_home.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FeedHomeFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_feed_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setJsonMock()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FeedHomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun setJsonMock() {
        JsonMockUtility().apply {
            val dataMock = getJsonToMock("teacher.json", ListTeacher::class.java)
            val food: AdapterList by lazy { AdapterList(listOf()) }
            list_teacher?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            list_teacher?.isNestedScrollingEnabled = false
            list_teacher?.adapter = food
            dataMock.results?.let { food.setItem(it) }
        }
    }




}
