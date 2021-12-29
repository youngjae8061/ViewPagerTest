package com.example.viewpagertest.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagertest.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtMain.text = "콘티넨탈 코리아에 오신 것을 환영합니다!"
        txtSub.text = "콘티넨탈 코리아 어플리케이션은\n보도자료, 채용, 지속 가능성, 사옵본부 소개 및 제품 정보 등\n회사에 대한 정보가 모여 있는 허브입니다."
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}