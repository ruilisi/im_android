package com.rls.im

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.chat.android.im.config.IM
import com.chat.android.im.config.UnifyDataConfig
import com.chat.android.im.helper.IMCallback

//proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
//./gradlew clean build bintrayUpload -PbintrayUser=ruilisi -PbintrayKey=9decbccb9878764e906a018567daa734bedb2221 -PdryRun=false
//./gradlew bintrayUpload -PbintrayUser=ruilisi -PbintrayKey=9decbccb9878764e906a018567daa734bedb2221 -PdryRun=false
//apply plugin: 'com.novoda.bintray-release'
//        publish {
//        repoName = 'IM.Chat.Android.SDK'//远程仓库名字,不指明，默认是上传到maven
//        userOrg = 'ruilisi'//bintray.com的用户名
//        groupId = 'com.chat.android.im'//jcenter上的路径
//        artifactId = 'im'//项目名称
//        publishVersion = '0.0.1'//版本号
//        desc = 'IM'//描述
////    website = "https://github.com/novoda/${rootProject.name}"//github 地址
//        }
class MainActivity : AppCompatActivity() {

    private lateinit var server: EditText
    private lateinit var roomId: EditText
    private lateinit var userId: EditText
    private lateinit var userToken: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        server = findViewById(R.id.server)
        roomId = findViewById(R.id.room_id)
        userId = findViewById(R.id.user_id)
        userToken = findViewById(R.id.user_token)
    }

    fun connect(view: View?) {

        if (server.text.trim().isEmpty()) {
            showToas("server can not be empty")
            return
        }

        if (roomId.text.trim().isEmpty()) {
            showToas("room id can not be empty")
            return
        }

        if (userId.text.trim().isEmpty()) {
            showToas("user id can not be empty")
            return
        }

        if (userToken.text.trim().isEmpty()) {
            showToas("user token can not be empty")
            return
        }


        val im = IM.getInstance(application)
        im.setDataConfig(dataConfig)
        im.openChat(object : IMCallback {
            override fun onFailure(error: String) {}
            override fun onSuccess() {}
        })
    }

    private val dataConfig: UnifyDataConfig
        private get() = UnifyDataConfig.Builder()
                .setUrl(server.text.toString())
                .setRoomId(roomId.text.toString())
                .setUserId(userId.text.toString())
                .setUserToken(userToken.text.toString())
                .build()


    private fun showToas(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

    }
}