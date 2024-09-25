package com.example.hocbanglaixe.modules

import com.example.hocbanglaixe.model.Exam
import com.example.hocbanglaixe.model.ExamQuestion
import com.example.hocbanglaixe.model.Question
import com.example.hocbanglaixe.model.__Class
import com.example.hocbanglaixe.model.__Permission
import com.example.hocbanglaixe.model.__Realm
import com.example.hocbanglaixe.model.__Role
import com.example.hocbanglaixe.model.__User
import io.realm.annotations.RealmModule

@RealmModule(classes = [Exam::class, ExamQuestion::class, Question::class, __Class::class, __Realm::class, __Role::class, __User::class, __Permission::class])
class Exam600Modules