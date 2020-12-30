package com.acexams.aceexam.activity

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.acexams.aceexam.R
import com.acexams.aceexam.aboutus.AboutUsActivity
import com.acexams.aceexam.acenotes.AceNotesActivity
import com.acexams.aceexam.acexamfaculty.AcexamFacultyActivity
import com.acexams.aceexam.activity.adpater.ListItemRowAdapter
import com.acexams.aceexam.activity.modal.ListItemRow
import com.acexams.aceexam.classes.ClassesFragement
import com.acexams.aceexam.contactus.ContactUsActivity
import com.acexams.aceexam.exam.ExamFragement
import com.acexams.aceexam.faq.FaqsActivity
import com.acexams.aceexam.home.HomeFragement
import com.acexams.aceexam.knowmore.KnowMoreActivity
import com.acexams.aceexam.peral.PearlsFragement
import com.acexams.aceexam.questiobank.QuestionBankFragement
import com.acexams.aceexam.search.SearchActivity
import com.acexams.aceexam.setting.SettingActivity
import com.acexams.aceexam.termandcondition.TermConditionActivity
import kotlinx.android.synthetic.main.activity_dash_board.*
import java.util.ArrayList


class DashBoardActivity : AppCompatActivity(), View.OnClickListener,AdapterView.OnItemClickListener{
    internal var doubleBackToExitPressedOnce = false
    var fragment:String=""
    lateinit var dialog:Dialog

    val titles = arrayOf(
        "Home",
        "Explore Acexam",
        "Enroll Now",
        "Study Metarial",
        "Acexam Faculty",
        "FAQ",
        "Share",
        "About Us",
        "Contact US",
        "T&C",
        "Log Out"
    )

    val titlesImages = arrayOf(
        R.drawable.home_new,
        R.drawable.know_more,
        R.drawable.buy_now,
        R.drawable.notes_new,
        R.drawable.faculty,
        R.drawable.faqs,
        R.drawable.share,
        R.drawable.about,
        R.drawable.contact_us,
        R.drawable.terms,
        R.drawable.log_out,
    )
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
       window.setFlags(
           WindowManager.LayoutParams.FLAG_SECURE,
           WindowManager.LayoutParams.FLAG_SECURE
       )

        drawer.setOnItemClickListener(this)
        openDrawerhome.setOnClickListener(this)
        searchdatadd.setOnClickListener{
            if(fragment=="home"){
                startActivity(Intent(this, SettingActivity::class.java))
            }else {
                startActivity(Intent(this, SearchActivity::class.java))
            }
        }
        fragment="home"
        searchdatadd.setImageResource(R.drawable.settingbtn)
        searchdatadd.visibility=View.VISIBLE
        switchfragment(HomeFragement(),false)
        listImplement()

        navigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> {
                    fragment="home"
                    dashboardtitle.text=" "
                    searchdatadd.visibility=View.VISIBLE
                    searchdatadd.setImageResource(R.drawable.settingbtn)
                    switchfragment(HomeFragement(),false)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_class -> {
                    fragment="hom"
                    dashboardtitle.text="Classess"
                    searchdatadd.setImageResource(R.drawable.ic_baseline_search_24)
                    searchdatadd.visibility=View.VISIBLE
                    switchfragment(ClassesFragement(),true)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_perals -> {
                    fragment="hom"
                    searchdatadd.setImageResource(R.drawable.ic_baseline_search_24)
                    searchdatadd.visibility=View.VISIBLE
                    dashboardtitle.text="Pearls"
                    switchfragment(PearlsFragement(),true)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_qbank -> {
                    fragment="hom"
                    searchdatadd.setImageResource(R.drawable.ic_baseline_search_24)
                    searchdatadd.visibility=View.VISIBLE
                    dashboardtitle.text="Question Bank"
                    switchfragment(QuestionBankFragement(),true)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_exm -> {
                    fragment="hom"
                    searchdatadd.setImageResource(R.drawable.ic_baseline_search_24)
                    searchdatadd.visibility=View.VISIBLE
                    dashboardtitle.text="Exam"
                    switchfragment(ExamFragement(),true)
                    return@setOnNavigationItemSelectedListener true
                }

            }
            false

        }
    }

    override fun onClick(v: View?) {
        when (v?.getId()) {
            R.id.openDrawerhome -> openDrawer()
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }


    override fun onBackPressed() {
        if (!(currentFag is HomeFragement))
        { switchfragment(HomeFragement(), false)
            navigationView.getMenu().findItem(R.id.nav_home).setChecked(true); 
        }else {
            exitlogout()
        }
//        AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
//            .setMessage("Are you sure you want to exit?")
//            .setPositiveButton("Yes",
//                DialogInterface.OnClickListener { dialog, which -> finish() })
//            .setNegativeButton("No", null).show()
    }


    fun exitlogout() {

        dialog = Dialog(this)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setContentView(R.layout.exitscreen)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog?.findViewById<Button>(R.id.tv_logout)?.setOnClickListener {
            dialog.dismiss()
            finish()
        }
        dialog?.findViewById<TextView>(R.id.tv_cancle)?.setOnClickListener {
            dialog.dismiss()
        }

        dialog?.show()
    }

    /*override fun onBackPressed() {
        val drawerLayout: androidx.drawerlayout.widget.DrawerLayout = findViewById(R.id.draweLayout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else if (!doubleBackToExitPressedOnce) run {
            this.doubleBackToExitPressedOnce = true
            Toast.makeText(this, "Please click BACK again to Exit.", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,DashBoardActivity::class.java))
            finish()
            Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 1000)
        }
        else run {
            super.onBackPressed()
        }

    }*/




    private fun listImplement() {
        val rowItems: MutableList<ListItemRow> =
            ArrayList<ListItemRow>()
        for (i in 0 until titles.size) {
            val item = ListItemRow(
                titles.get(i),
                titlesImages.get(i)
            )
            rowItems.add(item)
        }
        val listItemRowAdapter = ListItemRowAdapter(
            applicationContext,
            R.layout.drawer_layout, rowItems
        )
        drawer.setAdapter(listItemRowAdapter)




    }

    fun openDrawer() {
        if (!draweLayout.isDrawerOpen(drawerContainer)) {
            draweLayout.openDrawer(drawerContainer)
        } else {
            draweLayout.closeDrawer(drawerContainer)
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (position) {
            0 -> {
                draweLayout.closeDrawer(drawerContainer)
                val inapp = Intent(this, DashBoardActivity::class.java)
                 startActivity(inapp)
                 finish()
            }
            1 -> {
                draweLayout.closeDrawer(drawerContainer)
                val inapp = Intent(this, KnowMoreActivity::class.java)
                startActivity(inapp)
            }
            2 -> {
                draweLayout.closeDrawer(drawerContainer)
                var intent = Intent(this, ViewPalnsActivity::class.java)
                startActivity(intent)
            }
            3 -> {
                draweLayout.closeDrawer(drawerContainer)
                var intent = Intent(this, AceNotesActivity::class.java)
                startActivity(intent)
            }
            4 -> {
                draweLayout.closeDrawer(drawerContainer)
                val inapp = Intent(this, AcexamFacultyActivity::class.java)
                startActivity(inapp)
            }

            5 -> {
                draweLayout.closeDrawer(drawerContainer)
                val inapp = Intent(this, FaqsActivity::class.java)
                startActivity(inapp)
            }
            6 -> {
                val intent= Intent()
                intent.action= Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT,"Hey Check out this Great app:")
                intent.type="text/plain"
                startActivity(Intent.createChooser(intent,"Share To:"))

            }
            7->{
                draweLayout.closeDrawer(drawerContainer)
                val inapp = Intent(this, AboutUsActivity::class.java)
                startActivity(inapp)
            }
            8->{
                draweLayout.closeDrawer(drawerContainer)
                val inapp = Intent(this, ContactUsActivity::class.java)
                startActivity(inapp)
            }
            9->{
                draweLayout.closeDrawer(drawerContainer)
                val inapp = Intent(this, TermConditionActivity::class.java)
                startActivity(inapp)
            }
            10->{
                draweLayout.closeDrawer(drawerContainer)
                opendialog()
            }

        }
        draweLayout.closeDrawer(GravityCompat.START)

    }

    fun logout(){
        AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
            .setMessage("Are you sure you want to Logout")
            .setPositiveButton("LOGOUT",
                DialogInterface.OnClickListener {
                        dialog, which -> finish();
                    shareprefrences.clearAllPreferences(this);
                    startActivity(Intent(this, CommonActivity::class.java));
                    ActivityCompat.finishAffinity(this);

                })
            .setNegativeButton("CANCEL", null).show()

    }


    fun opendialog() {

        dialog = Dialog(this)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setContentView(R.layout.logout)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog?.findViewById<Button>(R.id.tv_logout)?.setOnClickListener {
            dialog.dismiss()
            shareprefrences.clearAllPreferences(this);
            startActivity(Intent(this, CommonActivity::class.java));
            ActivityCompat.finishAffinity(this);
        }
        dialog?.findViewById<TextView>(R.id.tv_cancle)?.setOnClickListener {
            dialog.dismiss()
        }

        dialog?.show()
    }


    var currentFag:Fragment?=null;
    fun switchfragment(fragment: Fragment, isBack: Boolean) {
        currentFag=fragment

        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        if (isBack) {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss()
//            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment)
                .commitAllowingStateLoss()
//            drawer_layout.closeDrawer(GravityCompat.START)
        }
    }
}