// Please note : @LinkingObjects and default values are not represented in the schema and thus will not be part of the generated models
package com.example.hocbanglaixe.model

import io.realm.RealmObject
import io.realm.RealmList
import io.realm.annotations.PrimaryKey

open class __Class : RealmObject() {

    @PrimaryKey
    var name: String = ""
    var permissions: RealmList<__Permission> = RealmList()

}
