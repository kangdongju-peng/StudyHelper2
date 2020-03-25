package com.example.studyhelper2

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MainListAdapter (val context: Context, val todoList: ArrayList<Todo>) : BaseAdapter(){
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View = LayoutInflater.from(context).inflate(R.layout.activity_main_item,null)

        val todoName = view.findViewById<TextView>(R.id.textview_name)

        val todo = todoList[position]
        todoName.text = todo.name

        return view
    }

    override fun getItem(position: Int): Any {
        return todoList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return todoList.size
    }


}