package com.text.ruilisi_im;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.nbsp.materialfilepicker.MaterialFilePicker;


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


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void go(View view) {

//        IM im = IM.getInstance(getApplication());
//        im.setDataConfig(getDataConfig());
//        im.openChat(new IMCallback() {
//            @Override
//            public void onFailure(String error) {
//
//            }
//
//            @Override
//            public void onSuccess() {
//
//            }
//        });


        openFile();
    }

    private void openFile() {

        new MaterialFilePicker()
                // Pass a source of context. Can be:
                //    .withActivity(Activity activity)
                //    .withFragment(Fragment fragment)
                //    .withSupportFragment(androidx.fragment.app.Fragment fragment)
                .withActivity(this)
                // With cross icon on the right side of toolbar for closing picker straight away
                .withCloseMenu(true)
                // Entry point path (user will start from it)
//                .withPath(alarmsFolder.getAbsolutePath())
                // Root path (user won't be able to come higher than it)
//                .withRootPath(externalStorage.getAbsolutePath())
                // Showing hidden files
//                .withHiddenFiles(true)
                // Want to choose only jpg images
//                .withFilter(Pattern.compile(".*\\.(jpg|jpeg)$"))
                // Don't apply filter to directories names
//                .withFilterDirectories(false)
//                .withTitle("Sample title")
                .withRequestCode(100)
                .start();
    }


//    private UnifyDataConfig getDataConfig() {
//
//        return new UnifyDataConfig.Builder()
//                .setUrl("wss://chat.esheeps.com/websocket")
//                .setRoomId("ZQTjpYHzu8etK5s5t")
//                .setUserId("2i984iAtbfPpYA78X")
//                .setUserToken("2KWPRX_fZsCKHMY8duT9VigBleXR8o52Jsa130fNvll")
//                .build();
//    }


}