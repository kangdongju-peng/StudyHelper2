package com.example.studyhelper2

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_setting.*
import java.util.*

class SettingActivity : AppCompatActivity() {

    lateinit var alarmManager: AlarmManager
    lateinit var context: Context
    lateinit var pendingIntent: PendingIntent
    lateinit var update_text : TextView
    var hour : Int = 0
    var min : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        this.context = this
        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        update_text = findViewById(R.id.update_textview)
        var myIntent : Intent = Intent(this,AlarmReceiver::class.java)

        timepicker_show.setOnClickListener {
            val now = Calendar.getInstance()
            val timePicker = TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay)
                calendar.set(Calendar.MINUTE,minute)
                calendar.set(Calendar.SECOND,0)
                calendar.set(Calendar.MILLISECOND,0)
                hour = hourOfDay
                min = minute
                var hr_str : String = hour.toString()
                var min_str : String = min.toString()
                if(hour > 12)
                    hr_str = (hour-12).toString()
                if(min<10)
                    min_str = "0$min"
                set_alarm_text("Alarm set to : $hr_str : $min_str")
            },now.get(Calendar.HOUR_OF_DAY),now.get(Calendar.MINUTE),false)
            timePicker.show()
        }
    }

    private fun set_alarm_text(s: String) {
            update_text.setText(s)
    }
}
