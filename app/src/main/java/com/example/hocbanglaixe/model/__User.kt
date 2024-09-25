// Please note : @LinkingObjects and default values are not represented in the schema and thus will not be part of the generated models
package com.example.hocbanglaixe.model

import com.example.hocbanglaixe.model.__Role
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class __User : RealmObject() {

    @PrimaryKey
    var id: String = ""
    var role: __Role? = null

}
