package com.acexams.aceexam.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HomeAdpater(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var fragementList:ArrayList<Fragment> = ArrayList<Fragment>();
    var titleList:ArrayList<String> = ArrayList<String>();

    override fun getCount(): Int {
        return  fragementList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragementList.get(position)

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList.get(position)
    }

    fun addFragement(fragment: Fragment, title:String){
        fragementList.add(fragment)
        titleList.add(title)

    }
}