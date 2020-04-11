package com.example.studyhelper2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import io.realm.Realm
import io.realm.Sort
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var realm:Realm? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Adapter = viewPageAdapter(supportFragmentManager)
        view_pager.adapter = Adapter
        view_pager.currentItem=1

        //Realm
        Realm.init(applicationContext)
        realm = Realm.getDefaultInstance()

    }

    override fun onDestroy() {
        super.onDestroy()
        realm?.close()
    }
    fun insertOrUpdate(todo: Todo){
        realm?.executeTransaction { realm ->
            val maxId = realm.where(Todo::class.java)?.max("toDoId")
            val nextId = (maxId?.toInt() ?: 0) + 1
            todo.toDoId = nextId
        }
        realm?.insertOrUpdate(todo)
    }
    fun findAll() : List<Todo>? {
        val results = realm?.where(Todo::class.java)
            ?.findAll()
            ?.sort("toDoId", Sort.DESCENDING)

        return results
    }
    fun findOneById(toDoId: Int):Todo? {
        val results = realm?.where(Todo::class.java)
            ?.equalTo("toDoId", toDoId)
            ?.findFirst()

        return results
    }
    private fun deleteById(toDoId: Int){
        realm?.executeTransaction {
            val targetTodo = it.where(Todo::class.java)
                .equalTo("toDoId", toDoId)
                .findFirst()
            targetTodo.deleteFromRealm()
        }
    }
}
