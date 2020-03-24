package com.example.studyhelper2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        button_done.setOnClickListener {
            if(edit_name.text != null){
                val intent = Intent(this,Page1Fragment::class.java)
                //intent.putExtra("name",edit_name.text.toString())
                startActivity(intent)
            }
        }
        button_cancle.setOnClickListener {
            val intent = Intent(this,Page1Fragment::class.java)
            startActivity(intent)
        }
    }
}
