// Please note : @LinkingObjects and default values are not represented in the schema and thus will not be part of the generated models
package com.example.hocbanglaixe.model

import com.example.hocbanglaixe.model.__Permission
import io.realm.RealmObject
import io.realm.RealmList
import io.realm.annotations.PrimaryKey

open class __Realm : RealmObject() {

    @PrimaryKey
    var id: Long = 0
    var permissions: RealmList<__Permission> = RealmList()

}
