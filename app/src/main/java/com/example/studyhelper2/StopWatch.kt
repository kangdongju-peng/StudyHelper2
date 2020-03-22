package com.example.studyhelper2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_timet_p_stopw.*


class StopWatch : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_timet_p_stopw, container, false)
        return root
    }
    // 뷰 생성이 완료되면 호출되는 메소드
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        timer_start_button.setOnClickListener {
            it.setBackgroundResource(R.drawable.pause_button)
        }
    }
    companion object {
        private const val num = "num"
        @JvmStatic
        fun newInstance(Number: Int): StopWatch {
            return StopWatch().apply {
                arguments = Bundle().apply {
                    putInt(num, Number)
                }
            }
        }
    }
}