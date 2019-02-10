package com.example.android.distributing

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class ImageTab : Fragment() {

    var imageFragmentView: View? = null
    var imageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        imageFragmentView = inflater.inflate(R.layout.fragment_image_tab, container, false)
        imageView = imageFragmentView!!.findViewById(R.id.imageInfo)
        setImageInfo(R.drawable.infographic1)
        return imageFragmentView
    }
        companion object {
            fun newInstance(): ImageTab = ImageTab()
    }

    fun setImageInfo(fileID: Int) {
        var filePath = "android.resource://" + javaClass.`package`.name + "/" + fileID.toString()
        var fileURI = Uri.parse(filePath)
        imageView!!.setImageURI(fileURI)
    }
}
