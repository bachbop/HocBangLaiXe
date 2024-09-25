// Please note : @LinkingObjects and default values are not represented in the schema and thus will not be part of the generated models
package com.example.hocbanglaixe.model

import io.realm.RealmObject

open class __Permission : RealmObject() {

    var role: __Role? = null
    var canRead: Boolean = false
    var canUpdate: Boolean = false
    var canDelete: Boolean = false
    var canSetPermissions: Boolean = false
    var canQuery: Boolean = false
    var canCreate: Boolean = false
    var canModifySchema: Boolean = false

}
