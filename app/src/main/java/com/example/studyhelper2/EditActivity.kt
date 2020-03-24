package com.example.studyhelper2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        val myFragment = Page1Fragment()

        button_done.setOnClickListener {
            if(edit_name.text != null){
                val bundle = Bundle(1)
                bundle.putString("name", edit_name.text.toString());
                myFragment.setArguments(bundle);


                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }



            }
        }

}
