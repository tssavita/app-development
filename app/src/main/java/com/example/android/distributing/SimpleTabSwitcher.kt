package com.example.android.distributing

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log

class SimpleTabSwitcher(fmAdapter : FragmentManager) : FragmentPagerAdapter(fmAdapter) {

    override fun getItem(position: Int): Fragment? = when (position) {
        0->VideoTab.newInstance()
        1->PptTab.newInstance()
        2->ImageTab.newInstance()
        else->null
    }
    override fun getPageTitle(position: Int): CharSequence = when (position) {
        0->"Videos"
        1->"Powerpoints"
        2->"Images"
        else->""
    }
    override fun getCount(): Int = 3
}