package com.example.studyhelper2

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_timet_p_stopw.*
import java.util.*
import kotlin.concurrent.timer


class StopWatch : Fragment(){
    private var timerTask : Timer? = null
    private var time :Int = 0
    private var mHandler :Handler = Handler()

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
            if(timerTask == null){
                startStopwatch()
            }
            else{
                pauseStopwatch()
            }
        }
    }
    companion object {
        private const val num = "num"
        @JvmStatic
        fun newInstance(Number: Int): StopWatch {
            return StopWatch().
                apply {
                arguments = Bundle().apply {
                    putInt(num, Number)
                }
            }
        }
    }
    @SuppressLint("SetTextI18n")
    private fun startStopwatch(){
        timer_start_button.setBackgroundResource(R.drawable.pause_button)
        timerTask = timer(period = 10) {
            time++
            val sec : String = String.format("%02d",time / 100 - time / 6000 * 60)
            val milli : String = String.format("%02d",time % 100)
            val min : String = String.format("%02d",time / 6000 - time / 360000 * 60)
            val hour : String = String.format("%02d",time / 360000)
            run(){
                mHandler.post(Runnable(){
                    run(){
                        timer_text.text = "$hour:$min:$sec.$milli"
                    }
                })
            }
        }
    }
    private fun pauseStopwatch(){
        timer_start_button.setBackgroundResource(R.drawable.start_button)
        timerTask?.cancel()
        timerTask =null
    }
}