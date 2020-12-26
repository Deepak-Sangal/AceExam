package com.acexams.aceexam.classes


import android.app.ActionBar
import android.app.AlertDialog
import android.app.Dialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.media.PlaybackParams
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.ClassesVideoActivity
import com.acexams.aceexam.activity.ImageAcivityActivity
import com.acexams.aceexam.activity.PdfReaderActivity
import com.acexams.aceexam.activity.ViewPalnsActivity
import com.acexams.aceexam.activity.modal.BookmarkResponse
import com.acexams.aceexam.activity.modal.NotesResponse
import com.acexams.aceexam.activity.modal.VideoBookmarkResponse
import com.acexams.aceexam.adapter.VideoClassesAdapter
import com.acexams.aceexam.bookmark.ReviewRatingModal
import com.acexams.aceexam.questiobank.adpater.slideResponse
import com.acexams.aceexam.retrofit.Constants.imageBaseUrlNewlive
import com.bumptech.glide.Glide
import com.acexams.aceexam.retrofit.ApiInterface
import com.github.barteksc.pdfviewer.listener.OnRenderListener
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_perarls.*
import kotlinx.android.synthetic.main.activity_start_exam.*
import kotlinx.android.synthetic.main.adapte_videolist.view.*
import kotlinx.android.synthetic.main.dialog_customtest.*
import kotlinx.android.synthetic.main.fragment_video_classes.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import shareprefrences


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class VideoClassesFragment : Fragment() {
var image=""
lateinit var videoURL:String
    lateinit var Video:VideoView
    lateinit var paid:String
    lateinit var Rating:String
    lateinit var dialog:Dialog
    lateinit var progDailog:ProgressDialog
    var review:String=""
    var videoid:String=""
    var rating:Float = 0.0f
   var  complete:String=""
    lateinit var mediaController:MediaController
lateinit var token:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_video_classes, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (context as ClassesVideoActivity).linearLayout.visibility=View.GONE
        videodescribe.text=shareprefrences.getStringPreference(activity!!, "chaptertitile").toString()
        ratingvalue.text=shareprefrences.getStringPreference(activity!!, "Rating").toString()
        paid=shareprefrences.getStringPreference(activity!!, "paid").toString()
        videoid=shareprefrences.getStringPreference(activity!!, "videoid").toString()
        complete=shareprefrences.getStringPreference(activity!!, "completed").toString()
        text.text=shareprefrences.getStringPreference(activity!!, "descrition").toString()
        Video= (view.findViewById(R.id.simpleVideoView) as VideoView)!!
        videoURL=shareprefrences.getStringPreference(activity!!, "VIDEO_URL").toString()
        if(paid=="1"){
            viewplans.visibility=View.VISIBLE
        }else{
            viewplans.visibility=View.GONE
        }
//        if(complete=="0"){
//            tv_complete.text="MAKE COMPLETE"
//        }else{
//            tv_complete.text="MAKE INCOMPLETE"
//        }
        videorcycle.isNestedScrollingEnabled = false
        videorcycle.layoutManager= LinearLayoutManager(activity)
//        notesrecycle.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,true)
//        videorcycle.adapter=VideoClassesAdapter(activity!!)
         mediaController = MediaController(activity)
//        mediaController.setPadding(150, 0, 150, 0);

        startvideo(1f, 0)

        viewplans.setOnClickListener{
            startActivity(Intent(activity!!, ViewPalnsActivity::class.java))
        }
        roate.setOnClickListener {
            if(dataaa.visibility==View.VISIBLE){
                dataaa.visibility=View.GONE
                layotdata.layoutParams.height=ActionBar.LayoutParams.MATCH_PARENT
                (context as ClassesVideoActivity).requestedOrientation=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            }else{
                dataaa.visibility=View.VISIBLE
                  layotdata.layoutParams.height=500
                (context as ClassesVideoActivity).requestedOrientation=ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }
        }
        seemore.setOnClickListener{
            if(videodescribe.maxLines==3){
                videodescribe.maxLines=Integer.MAX_VALUE
            }else{
                videodescribe.maxLines=3
            }
        }
        videocompletion.setOnClickListener{
            if (complete=="0"){
                complete="1"
            }else{
                complete="0"
            }
            completestatus()
//            opendialog()
        }
        makecomplete.setOnClickListener{
            opendialog()
        }


        imsssageeeee.setOnClickListener{
          /*  var intent =  Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse(image), "application/pdf");*/
            var intent=Intent(context,PdfReaderActivity::class.java)
            intent.putExtra("pdf",image)
            startActivity(intent)
        }




        bookmark()
        notes()
        slide()
        imageeeee.setOnClickListener {
            var inetent = Intent(activity, ImageAcivityActivity::class.java)
        }

        img_menu.setOnClickListener {
            showPictureialog()
        }
        Video.setOnPreparedListener(MediaPlayer.OnPreparedListener {
       // progDailog.dismiss()
            buffering_textview.visibility=View.GONE
        })


    }


    fun opendialog() {
        dialog = Dialog(activity!!)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setContentView(R.layout.dialog_ratingreview)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
//        dialog?.findViewById<TextView>(R.id.changenumber)!!.visibility = View.GONE
        dialog?.findViewById<TextView>(R.id.sumitrating)?.setOnClickListener {
            rating= dialog?.findViewById<RatingBar>(R.id.ratingBar)?.rating!!
            review= dialog?.findViewById<TextView>(R.id.review)?.text.toString()
            if(rating.toString().isEmpty()){
                Toast.makeText(activity,"Please Select Rating",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(review.toString().isEmpty()){
                Toast.makeText(activity,"Please Enter Review",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            sumitreview()
        }
        dialog?.show()
    }



    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            dataaa.visibility=View.GONE
            layotdata.layoutParams.height=ActionBar.LayoutParams.MATCH_PARENT
//            (context as ClassesVideoActivity).requestedOrientation=ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            getActivity()!!.getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
            getActivity()!!.getWindow().clearFlags(
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN
            );
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            dataaa.visibility=View.VISIBLE
            layotdata.layoutParams.height=500

//            (context as ClassesVideoActivity).requestedOrientation=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            getActivity()!!.getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN
            );
            getActivity()!!.getWindow().clearFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            );

        }
    }

    fun bookmark(){
        token=shareprefrences.getStringPreference(activity!!, "ACCESS_TOKEN").toString()
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.bookmark(
            "Bearer " + token, shareprefrences.getStringPreference(
                activity!!,
                "VIDEO_ID"
            ).toString()
        )
        call.enqueue(object : Callback<BookmarkResponse> {
            override fun onResponse(
                call: Call<BookmarkResponse>,
                response: Response<BookmarkResponse>
            ) {
                if (response.code() == 200) {
                    videorcycle.adapter = VideoClassesAdapter(
                        activity!!,
                        response.body()!!.data,
                        Video!!
                    )
                } else if (response.code() == 400) {
                    Toast.makeText(activity, "Bookmark Not Found", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<BookmarkResponse>, t: Throwable) {
                Log.e("data", t.toString())
            }

        })
    }

    private fun showPictureialog() {
        val items = arrayOf<CharSequence>("0.75f", "1f", "1.2f", "1.5f", "1.8f", "2f")
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setItems(items,
            DialogInterface.OnClickListener { dialog, item ->
                if (item == 0) {

                    startvideo(0.75f, Video.currentPosition)
                } else if (item == 1) {
                    startvideo(1f, Video.currentPosition)
                } else if (item == 2) {
                    startvideo(1.2f, Video.currentPosition)
                } else if (item == 3) {
                    startvideo(1.5f, Video.currentPosition)
                } else if (item == 4) {
                    startvideo(1.8f, Video.currentPosition)
                } else if (item == 5) {
                    startvideo(3f, Video.currentPosition)
                }
            })

        val dialog: AlertDialog = builder.create()
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val wmlp: WindowManager.LayoutParams = dialog.getWindow()!!.getAttributes()

        wmlp.gravity = Gravity.BOTTOM
//        or Gravity.LEFT
//        wmlp.x = 100 //x position

//        wmlp.y = 100 //y position


        dialog.show()
    }
    fun startvideo(speed: Float, duration: Int){
        Video.setVideoURI(Uri.parse(videoURL))
//        Video.setData(Uri.parse(videoURL))
//        DialogUtils.showProgressLoadingBar(context)
      //  progDailog = ProgressDialog.show(activity, "Please wait ...", "Retrieving data ...", true);


        if(paid=="0") {
            Video.setMediaController(mediaController)
        }

//        simpleVideoView.seekTo(60000*1)
        Video.setOnPreparedListener(MediaPlayer.OnPreparedListener {
//            progDailog.dismiss()
            var myPlayBackParams: PlaybackParams? = null
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                myPlayBackParams = PlaybackParams()
                myPlayBackParams.speed = speed //you can set speed here
                it.setPlaybackParams(myPlayBackParams)
            }
            // it.playbackParams.setSpeed(0.3f)

        })
        if(duration!=0) {
            Video.seekTo(duration)
        }
        mediaController.setAnchorView(Video)
        if(paid=="0") {
            Video.start()
        }
    }

    fun notes(){
        token=shareprefrences.getStringPreference(activity!!, "ACCESS_TOKEN").toString()
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.Notes(
            "Bearer " + token, shareprefrences.getStringPreference(
                activity!!,
                "VIDEO_ID"
            ).toString()
        )
        call.enqueue(object : Callback<NotesResponse>, OnRenderListener {
            override fun onResponse(
                call: Call<NotesResponse>,
                response: Response<NotesResponse>
            ) {
                if (response.code() == 200) {
                    if( response.body()!!.data.notesData.size>0){
image=imageBaseUrlNewlive + "notes/" + response.body()!!.data.notesData[0].note_file_name
    Log.e("pdf",image)

                    }
                } else if (response.code() == 400) {
                    Toast.makeText(activity, "Bookmark Not Found", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<NotesResponse>, t: Throwable) {
                Log.e("data", t.toString())
            }

            override fun onInitiallyRendered(nbPages: Int, pageWidth: Float, pageHeight: Float) {
                TODO("Not yet implemented")
            }

        })
    }


    fun slide(){
        token=shareprefrences.getStringPreference(activity!!, "ACCESS_TOKEN").toString()
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.slides(
            "Bearer " + token, shareprefrences.getStringPreference(
                activity!!,
                "VIDEO_ID"
            ).toString()
        )
        call.enqueue(object : Callback<slideResponse>, OnRenderListener {
            override fun onResponse(
                call: Call<slideResponse>,
                response: Response<slideResponse>
            ) {
                if (response.code() == 200) {
                    if(response.body()!!.data.slideData.size>0) {
                        image =
                            "http://www.acexam.com/web/public/uploads/slides/" + response.body()!!.data.slideData[0].slide_file_name
                        Glide.with(this@VideoClassesFragment).asBitmap()
                            .load(("http://www.acexam.com/web/public/uploads/slides/" + response.body()!!.data.slideData[0].slide_file_name))
                            .into(imageeeee)
                    }
                    } else if (response.code() == 400) {
                    Toast.makeText(activity, "Bookmark Not Found", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<slideResponse>, t: Throwable) {
                Log.e("data", t.toString())
            }

            override fun onInitiallyRendered(nbPages: Int, pageWidth: Float, pageHeight: Float) {
                TODO("Not yet implemented")
            }

        })
    }


    fun sumitreview(){
        token=shareprefrences.getStringPreference(activity!!, "ACCESS_TOKEN").toString()
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.reviewandrating(
            "Bearer " + token,
            shareprefrences.getStringPreference(
                activity!!,
                "USER_ID"
            ).toString(),
            shareprefrences.getStringPreference(
                activity!!,
                "VIDEO_ID"
            ).toString(),
            review,rating.toString()
        )
        call.enqueue(object : Callback<ReviewRatingModal> {
            override fun onResponse(
                call: Call<ReviewRatingModal>,
                response: Response<ReviewRatingModal>
            ) {
                if (response.code() == 200) {
                    Toast.makeText(activity, "Sumited", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                } else if (response.code() == 400) {
                    Toast.makeText(activity, "Bookmark Not Found", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ReviewRatingModal>, t: Throwable) {
                Log.e("data", t.toString())
            }

        })
    }

    fun completestatus(){
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.makecompeted(
            videoid,
            shareprefrences.getStringPreference(activity!!, "USER_ID").toString(),
            complete
        )
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if(response.code()==200){
                    var obj= response.body()?.string()
                    var json = JSONObject(obj)
                    var status = json.getString("status")
                    if (status.toInt()==200){
                        var message=json.getString("message")
                        Toast.makeText(activity,message,Toast.LENGTH_SHORT).show()
                        if (complete=="0"){
                            videocompletion.setImageResource(R.drawable.done_24)
                        }else{
                            videocompletion.setImageResource(R.drawable.ic_baseline_done_24)
                        }
                    }
                    else if (status.toInt()==401){
                        var message=json.getString("message")
                        Toast.makeText(activity,message,Toast.LENGTH_SHORT).show()
                    }

                }else{
                    Toast.makeText(activity,"Something went wrong",Toast.LENGTH_SHORT)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("data",t.toString())
            }

        })
    }

    fun unbookkmark(){
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.videobookmark(
            videoid,
            "Bearer " + token,
            "0"
        )
        call.enqueue(object : Callback<VideoBookmarkResponse> {
            override fun onResponse(call: Call<VideoBookmarkResponse>, response: Response<VideoBookmarkResponse>) {
                if (response.code()==200){
                    if(response.body()!!.status==200){
                        bookmarkchange.setImageResource(R.drawable.redbookmark)
                    }
                }
            }

            override fun onFailure(call: Call<VideoBookmarkResponse>, t: Throwable) {
                Log.e("data",t.toString())
            }

        })
    }

    fun bookkmark(){
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.videobookmark(
            videoid,
            "Bearer " + token,
            "0"
        )
        call.enqueue(object : Callback<VideoBookmarkResponse> {
            override fun onResponse(call: Call<VideoBookmarkResponse>, response: Response<VideoBookmarkResponse>) {
                if (response.code()==200){
                    if(response.body()!!.status==200){
                        bookmarkchange.setImageResource(R.drawable.unbookmark)
                    }else{
                        Toast.makeText(activity,"Something Went Wrong",Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<VideoBookmarkResponse>, t: Throwable) {
                Log.e("data",t.toString())
                Toast.makeText(activity,"Something Went Wrong",Toast.LENGTH_SHORT).show()
            }

        })
    }






}