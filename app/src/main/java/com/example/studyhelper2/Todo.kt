package com.example.studyhelper2

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Todo(@PrimaryKey open var toDoId:Int? = null,
                open var name : String? = null,
                open var date : String? = null) : RealmObject()
