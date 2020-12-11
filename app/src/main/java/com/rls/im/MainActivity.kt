package com.rls.im

import android.os.Bundle
import android.view.View
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun connect(view: View?) {
        val im = IM.getInstance(application)
        im.setDataConfig(dataConfig)
        im.openChat(object : IMCallback {
            override fun onFailure(error: String) {}
            override fun onSuccess() {}
        })
    }

    private val dataConfig: UnifyDataConfig
        private get() = UnifyDataConfig.Builder()
                .setUrl("wss://chat.esheeps.com/websocket")
                .setRoomId("ZQTjpYHzu8etK5s5t")
                .setUserId("2i984iAtbfPpYA78X")
                .setUserToken("2KWPRX_fZsCKHMY8duT9VigBleXR8o52Jsa130fNvll")
                .build()
}