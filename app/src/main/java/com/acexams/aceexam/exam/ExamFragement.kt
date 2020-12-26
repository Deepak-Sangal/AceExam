package com.acexams.aceexam.exam


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.acexams.aceexam.R
import com.acexams.aceexam.adapter.HomeAdpater
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_exam_fragement.*


class ExamFragement : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_exam_fragement, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUPViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(activity!!, R.color.white));//put your color


        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }

    private fun setUPViewPager(viewPager: ViewPager?) {
        var adpater= HomeAdpater(childFragmentManager)
        adpater.addFragement(GrandTestFragment(), "Grand Test")
        adpater.addFragement(AllTestFragment(), "All Tests")
        adpater.addFragement(MiniFragment(), "Mini Test")
        adpater.addFragement(SubjectWiseFragment(), "Subject Wise Test")
        viewPager?.adapter =adpater
    }




}