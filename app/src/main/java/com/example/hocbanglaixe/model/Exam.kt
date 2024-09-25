// Please note : @LinkingObjects and default values are not represented in the schema and thus will not be part of the generated models
package com.example.hocbanglaixe.model

import io.realm.RealmObject
import io.realm.annotations.Index
import io.realm.annotations.PrimaryKey

open class Exam : RealmObject() {

    @PrimaryKey
    var objectID: String = ""
    @Index
    var licenseType: Long = 0
    @Index
    var examID: Long = 0
    @Index
    var sortIndex: Long = 0

}
