package com.example.msi_gl62.simpelapp.fragment.lesson
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.msi_gl62.simpelapp.JsonMockUtility
import com.example.msi_gl62.simpelapp.R
import com.example.msi_gl62.simpelapp.fragment.lesson.adapter.AdapterListEn
import com.example.msi_gl62.simpelapp.fragment.lesson.adapter.AdapterListMathematics
import com.example.msi_gl62.simpelapp.fragment.lesson.adapter.AdapterListScience
import com.example.msi_gl62.simpelapp.model.ListLesson
import kotlinx.android.synthetic.main.fragment_feed_new.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FeedNewFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_feed_new, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mockJson()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FeedNewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun mockJson(){
        JsonMockUtility().apply {
            val dataMock = getJsonToMock("lesson_sc.json", ListLesson::class.java)
            val sc: AdapterListScience by lazy { AdapterListScience(listOf()) }
            list_sc?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            list_sc?.isNestedScrollingEnabled = false
            list_sc?.adapter = sc
            dataMock.results?.let { sc.setItem(it) }
        }

        JsonMockUtility().apply {
            val dataMock = getJsonToMock("lesson_en.json", ListLesson::class.java)
            val en: AdapterListEn by lazy { AdapterListEn(listOf()) }
            list_en?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            list_en?.isNestedScrollingEnabled = false
            list_en?.adapter = en
            dataMock.results?.let { en.setItem(it) }
        }

        JsonMockUtility().apply {
            val dataMock = getJsonToMock("lesson_math.json", ListLesson::class.java)
            val ma: AdapterListMathematics by lazy { AdapterListMathematics(listOf()) }
            list_ma?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            list_ma?.isNestedScrollingEnabled = false
            list_ma?.adapter = ma
            dataMock.results?.let { ma.setItem(it) }
        }
    }
}
