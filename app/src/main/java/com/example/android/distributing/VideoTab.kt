package com.example.android.distributing

import android.support.v7.app.AppCompatActivity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.util.Log
import android.widget.TextView

class VideoTab : Fragment() {
    var namoresponseVideo: VideoView? = null
    var promomaterialVideo: VideoView? = null
    var howsaukpadsrmadeVideo: VideoView? = null
    var videoFragmentView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        videoFragmentView = inflater.inflate(R.layout.fragment_video_tab, container, false)
        //var helloText = videoFragmentView!!.findViewById<TextView>(R.id.hello_video)
        Log.i("VideoTab", "In Video Tab")
        setVideos()
        return videoFragmentView!!
    }

    companion object {
        fun newInstance(): VideoTab = VideoTab()
    }

    fun setVideos() {
        namoresponseVideo = videoFragmentView!!.findViewById(R.id.namo_response)
        setEachVideo(namoresponseVideo!!, R.raw.namo_response)

        promomaterialVideo = videoFragmentView!!.findViewById(R.id.promo_video)
        setEachVideo(promomaterialVideo!!, R.raw.promo_video)

        howsaukpadsrmadeVideo = videoFragmentView!!.findViewById(R.id.howitsmade)
        setEachVideo(howsaukpadsrmadeVideo!!, R.raw.saukhyam_pad_how_its_made)
    }

    fun setEachVideo(videoViewElement : VideoView, videoRaw : Int) {
        var videoSrc = "android.resource://" + javaClass.`package`.name + "/" + videoRaw
        Log.i("VideoSrc", videoSrc)
        var videoUri = Uri.parse(videoSrc)
        videoViewElement.setVideoURI(videoUri)

        var mediaController = MediaController(this.context)
        videoViewElement.setMediaController(mediaController)




    }

}
