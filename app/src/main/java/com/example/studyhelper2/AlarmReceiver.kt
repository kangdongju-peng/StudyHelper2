package com.example.studyhelper2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.Ringtone
import android.util.Log

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var getResult : String = intent!!.getStringExtra("extra")
        var service_intent : Intent = Intent(context,RingtoneService::class.java)
        service_intent.putExtra("extra",getResult)
        context!!.startService(service_intent)
    }

}