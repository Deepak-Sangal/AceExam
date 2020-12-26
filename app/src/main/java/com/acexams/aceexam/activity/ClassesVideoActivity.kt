package com.acexams.aceexam.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.acexams.aceexam.R
import com.acexams.aceexam.classes.NotesFragment
import com.acexams.aceexam.classes.SlidersFragment
import com.acexams.aceexam.classes.VideoClassesFragment
import kotlinx.android.synthetic.main.activity_classes_video.*

class ClassesVideoActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var linearLayout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_classes_video)
        linearLayout=findViewById(R.id.hearder)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        titleqwe.text=intent.getStringExtra("chaptertitile").toString()
        videoclass.setOnClickListener(this)
        sliders.setOnClickListener(this)
        notes.setOnClickListener(this)
        backvideo.setOnClickListener(this)
        loadFragment(VideoClassesFragment())
        videoclass.background=resources.getDrawable(R.drawable.whitefill)
        videoclass.setTextColor(resources.getColor(R.color.black))
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.containeri, fragment)
        transaction.disallowAddToBackStack()
        transaction.commit()
    }


    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.videoclass->{
                loadFragment(VideoClassesFragment())
                videoclass.background=resources.getDrawable(R.drawable.whitefill)
                videoclass.setTextColor(resources.getColor(R.color.black))
                sliders.background=resources.getDrawable(R.drawable.whitelayout)
                sliders.setTextColor(resources.getColor(R.color.white))
                notes.background=resources.getDrawable(R.drawable.whitelayout)
                notes.setTextColor(resources.getColor(R.color.white))
            }
            R.id.sliders->{
                loadFragment(SlidersFragment())
                videoclass.background=resources.getDrawable(R.drawable.whitelayout)
                videoclass.setTextColor(resources.getColor(R.color.white))
                sliders.background=resources.getDrawable(R.drawable.whitefill)
                sliders.setTextColor(resources.getColor(R.color.black))
                notes.background=resources.getDrawable(R.drawable.whitelayout)
                notes.setTextColor(resources.getColor(R.color.white))
            }
            R.id.notes->{
                videoclass.background=resources.getDrawable(R.drawable.whitelayout)
                videoclass.setTextColor(resources.getColor(R.color.white))
                sliders.background=resources.getDrawable(R.drawable.whitelayout)
                sliders.setTextColor(resources.getColor(R.color.white))
                notes.background=resources.getDrawable(R.drawable.whitefill)
                notes.setTextColor(resources.getColor(R.color.black))
                loadFragment(NotesFragment())
            }
            R.id.backvideo->{
                onBackPressed()
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}