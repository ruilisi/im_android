package com.rls.im

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.chat.android.im.config.IM
import com.chat.android.im.config.UnifyDataConfig
import com.chat.android.im.helper.IMCallback
import com.rls.pickfile.android.activity.FilePickerActivity
import com.rls.pickfile.android.viewmodel.FilePickerViewModel

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