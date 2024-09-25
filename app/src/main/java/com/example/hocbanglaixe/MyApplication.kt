package com.example.hocbanglaixe

import android.app.Application
import android.content.Context
import com.example.hocbanglaixe.modules.Exam600Modules
import com.example.hocbanglaixe.modules.Question600Modules
import io.realm.Realm
import io.realm.RealmConfiguration
import java.io.File

class MyApplication: Application() {
    companion object {
        lateinit var realmExamConfig : Realm
        lateinit var realmQuestionConfig: Realm
    }
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        copyRealmFile(this, "HBLExam600.realm", "HBLExam600.realm")
        val examConfig = setupRealm(
            this, "HBLExam600.realm",
            "6a66376c774371574a686c685434325a4f61304c55646c66534c79575671393143394461356733476331683766767a37734f37557379357a5670616865547756",
            2,
            Exam600Modules()
        )

        copyRealmFile(this, "HBLQuestion600.realm", "HBLQuestion600.realm")
        val questionConfig = setupRealm(
            this, "HBLQuestion600.realm",
            "6a66376c774371574a686c685434325a4f61304c55646c66534c79575671393143394461356733476331683766767a37734f37557379357a5670616865547756",
            3,
            Question600Modules()
        )

        realmExamConfig = Realm.getInstance(examConfig)

        realmQuestionConfig = Realm.getInstance(questionConfig)

        Realm.setDefaultConfiguration(questionConfig)
    }
}

fun copyRealmFile(context: Context, inputFile: String, outputFiles: String) {
    val inputStream = context.assets.open(inputFile)
    val outputFile = File(context.filesDir, outputFiles)
    inputStream.use { input ->
        outputFile.outputStream().use { output ->
            input.copyTo(output)
        }
    }
}

fun setupRealm(
    context: Context,
    child: String,
    encryptKey: String,
    schemaVersion: Long,
    module: Any
): RealmConfiguration {
    val realmFile = File(context.filesDir, child)
    val key = encryptKey.chunked(2).map { it.toInt(16).toByte() }.toByteArray()
    val config = RealmConfiguration.Builder()
        .name(realmFile.name)
        .encryptionKey(key)
        .schemaVersion(schemaVersion)
        .modules(module)
        .build()

    return config
}