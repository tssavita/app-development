package com.example.android.distributing

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.provider.MediaStore
import android.widget.VideoView

class UsageMaterial : AppCompatActivity() {

    var namoresponseVideo: VideoView? = null
    var promomaterialVideo: VideoView? = null
    var howsaukpadsrmadeVideo: VideoView? = null
    var assetsPath = Environment.getExternalStorageDirectory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usage_material)
        setvideos()
    }
    fun setvideos() {
        Log.i("UsageMaterial", "here" + assetsPath!!.toString())
        namoresponseVideo.setVideoPath("android.resource://assets/videos/namo_response.mp4")
    }
}
