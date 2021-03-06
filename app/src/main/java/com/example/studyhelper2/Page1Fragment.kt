package com.example.studyhelper2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_edit.view.*
import kotlinx.android.synthetic.main.fragment_1.*
import kotlinx.android.synthetic.main.fragment_1.view.*
import kotlinx.android.synthetic.main.fragment_1.view.button_add


class Page1Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_1, container, false)

        val name = getArguments()!!.getString("name")



        return root


    }
    // 뷰 생성이 완료되면 호출되는 메소드
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var todoList = arrayListOf<Todo>()
        val todoAdapter = MainListAdapter(context!!,todoList)
        listView.adapter = todoAdapter
        button_add.setOnClickListener {
            startActivity(Intent(context,EditActivity::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }
    companion object {
        private const val num = "num"
        @JvmStatic
        fun newInstance(Number: Int): Page1Fragment {
            return Page1Fragment().apply {
                arguments = Bundle().apply {
                    putInt(num, Number)
                }
            }
        }
    }
}