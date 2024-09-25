// Please note : @LinkingObjects and default values are not represented in the schema and thus will not be part of the generated models
package com.example.hocbanglaixe.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class TipTheory : RealmObject() {

    @PrimaryKey
    var objectID: String = ""
    var title: String = ""
    var content: String = ""
    var titleU: String = ""
    var contentU: String = ""

}
