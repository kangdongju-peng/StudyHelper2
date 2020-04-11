package com.example.studyhelper2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_edit_.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_edit_)

        button_done.setOnClickListener {
            if(edit_name.text != null){
                val intent = Intent()
                intent.putExtra("Name", edit_name.text)
                val bundle = Bundle(1)
                bundle.putString("name", edit_name.text.toString());
                //myFragment.setArguments(bundle);
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
        button_cancle.setOnClickListener{
            finish()
        }
    }

}
