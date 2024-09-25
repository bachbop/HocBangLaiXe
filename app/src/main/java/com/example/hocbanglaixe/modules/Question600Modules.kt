package com.example.hocbanglaixe.modules

import com.example.hocbanglaixe.model.Question
import com.example.hocbanglaixe.model.TipTheory
import com.example.hocbanglaixe.model.__Class
import com.example.hocbanglaixe.model.__Permission
import com.example.hocbanglaixe.model.__Realm
import com.example.hocbanglaixe.model.__Role
import com.example.hocbanglaixe.model.__User
import io.realm.annotations.RealmModule

@RealmModule(classes = [Question::class, TipTheory::class, __Class::class, __Realm::class, __Role::class, __User::class, __Permission::class])
class Question600Modules