package com.example.studyhelper2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Adapter = viewPageAdapter(supportFragmentManager)
        view_pager.adapter = Adapter
        view_pager.currentItem=0
        // 탭 레아아웃에 뷰페이저 연결
        tabs.setupWithViewPager(view_pager)
        // 탭뷰 각각 이름 만들기
        val feel=arrayOf("TodoList","Timetable","Downtime")
        for(i in 0..2)
            tabs.getTabAt(i)?.setText(feel[i])
    }
}
