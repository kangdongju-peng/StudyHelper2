package com.example.studyhelper2

import android.annotation.SuppressLint
import android.app.ActionBar
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_timet_p_stopw.*
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timer


class StopWatch : Fragment(){
    private var timerTask : Timer? = null
    private var time :Int = 0
    private var mHandler :Handler = Handler()
    private var scrollView : ScrollView? = null
    private var arrayTime :ArrayList<TextView>? = null
    private var matchToParant :Int = 0

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
        scrollView = getView()!!.findViewById(R.id.timetable_scv) as ScrollView
        matchToParant = scrollView!!.getWidth()

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
    @SuppressLint("ResourceAsColor")
    private fun setTimeTableUI(){
        val tableRowParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0)
        tableRowParams.weight = 1f
        val timeParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT)
        timeParams.weight = 1.5f
        for(i in 0 until 24){
            var tableLayout = getView()!!.findViewById<TableLayout>(R.id.table_layout)
            arrayTime = ArrayList<TextView>()
            var tableRow = TableRow(context)
            tableRow.layoutParams = tableRowParams
            tableRow.weightSum = 13.5f
            var tv = TextView(context)
            tv.layoutParams = timeParams




        }
    }
}