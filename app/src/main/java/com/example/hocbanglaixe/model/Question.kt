// Please note : @LinkingObjects and default values are not represented in the schema and thus will not be part of the generated models
package com.example.hocbanglaixe.model


import io.realm.RealmObject
import io.realm.RealmList
import io.realm.annotations.Required
import io.realm.annotations.PrimaryKey

open class Question : RealmObject() {

    @PrimaryKey
    var objectID: String = ""
    var questionID: Long = 0
    var questionType: Long = 0
    var sortIndex: Long = 0
    var content: String = ""
    var contentU: String = ""
    var isHaveImage: Boolean = false
    var imageWidth: Long = 0
    var imageHeight: Long = 0
    var imageData: ByteArray? = null
    var option1: String? = null
    var option2: String? = null
    var option3: String? = null
    var option4: String? = null
    var option1U: String? = null
    var option2U: String? = null
    var option3U: String? = null
    var option4U: String? = null
    @Required
    var answerList: RealmList<Long> = RealmList()
    var answerExplain: String = ""
    var answerExplainU: String = ""
    var isBelongA1: Boolean = false
    var isBelongA2: Boolean = false
    var isBelongA3A4: Boolean = false
    var isBelongB1: Boolean = false
    var learnedCount: Long = 0
    var wrongCount: Long = 0
    var isFavorited: Boolean = false
    var isWrongAnswer: Boolean = false
    @Required
    var lastAnswers: RealmList<Long> = RealmList()

}
