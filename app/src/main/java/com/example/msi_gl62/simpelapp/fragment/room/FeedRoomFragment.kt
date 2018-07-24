package com.example.msi_gl62.simpelapp.fragment.room

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.msi_gl62.simpelapp.R
import com.example.msi_gl62.simpelapp.model.RoomEven
import com.example.msi_gl62.simpelapp.model.TestModel
import kotlinx.android.synthetic.main.activity_testwebview.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@Suppress("UNREACHABLE_CODE")
class FeedRoomFragment : Fragment(),FeedRoomContact.View {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var presenter: FeedRoomContact.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_feed_room, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = FeedRoomPresenter(this)
        presenter.callListFoodApi()
        presenter.callListFoodApiTest()
        test()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FeedRoomFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCallSuccess(dataList: List<RoomEven>?) {
       Log.e("testLog", "txt.............*****--..=$dataList")
    }

    override fun onCallSuccessTest(data: List<TestModel>?) {
        Log.e("testLog", "txt.../////............=$data")
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun test() {
        webView.getSettings().setJavaScriptEnabled(true)
        webView.loadUrl("http://demo.appedr.com:8088/edr_android/parentDashboard?_studentId=4569")
        webView.webViewClient = WebViewClient()
    }

}
