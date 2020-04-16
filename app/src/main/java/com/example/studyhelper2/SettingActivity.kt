package com.example.studyhelper2

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_setting.*
import java.util.*

class SettingActivity : AppCompatActivity() {

    lateinit var alarmManager: AlarmManager
    lateinit var timePicker: TimePicker
    lateinit var update_text : TextView
    lateinit var context: Context
    lateinit var btnStart : Button
    lateinit var btnStop : Button
    lateinit var pendingIntent: PendingIntent
    var hour : Int = 0
    var min : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        this.context = this
        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        timePicker = findViewById(R.id.timePicker2) as TimePicker
        update_text = findViewById(R.id.update_textview) as TextView
        btnStart = findViewById(R.id.timepicker_show) as Button
        btnStop = findViewById(R.id.stopbtn) as Button
        var calendar : Calendar = Calendar.getInstance()
        var myIntent : Intent = Intent(this,AlarmReceiver::class.java)
        btnStart.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    calendar.set(Calendar.HOUR_OF_DAY,timePicker.hour)
                    calendar.set(Calendar.MINUTE,timePicker.minute)
                    calendar.set(Calendar.SECOND,0)
                    calendar.set(Calendar.MILLISECOND,0)
                    hour = timePicker.hour
                    min = timePicker.minute
                    Log.d("**","goood")

                }
                else{
                    Log.d("**","failedwithversion")
                    calendar.set(Calendar.HOUR_OF_DAY,timePicker.currentHour)
                    calendar.set(Calendar.MINUTE,timePicker.currentMinute)
                    calendar.set(Calendar.SECOND,0)
                    calendar.set(Calendar.MILLISECOND,0)
                    hour = timePicker.currentHour
                    min = timePicker.currentMinute
                }
                var hr_str : String = hour.toString()
                var min_str : String = min.toString()
                if(hour > 12){
                    hr_str = (hour-12).toString()
                }
                if(min < 10){
                    min_str = "0$min"
                }
                set_alarm_text("Alarm set to : $hr_str : $min_str")
                myIntent.putExtra("extra","on")
                pendingIntent = PendingIntent.getBroadcast(this@SettingActivity,0,myIntent,PendingIntent.FLAG_UPDATE_CURRENT)
                alarmManager.setExact(AlarmManager.RTC_WAKEUP,calendar.timeInMillis,pendingIntent)
            }
        })
        btnStop.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                set_alarm_text("Alarm off")
                pendingIntent = PendingIntent.getBroadcast(this@SettingActivity,0,myIntent,PendingIntent.FLAG_UPDATE_CURRENT)
                alarmManager.cancel(pendingIntent)
                sendBroadcast(myIntent)
                myIntent.putExtra("extra","off")
            }
        })
    }

    private fun set_alarm_text(s: String) {
        update_text.setText(s)

    }

}
