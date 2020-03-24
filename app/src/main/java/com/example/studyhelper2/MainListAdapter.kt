package com.example.studyhelper2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MainListAdapter (val context: Context, val todoList: ArrayList<Todo>) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
        val view : View = LayoutInflater.from(context).inflate(R.layout.activity_main_item,null)

        val todoName = view.findViewById<TextView>(R.id.textview_name)

        val todo = todoList[position]
        todoName.text = todo.name

        return view
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
        return todoList[position]
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
        return 0
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
        return todoList.size
    }


}