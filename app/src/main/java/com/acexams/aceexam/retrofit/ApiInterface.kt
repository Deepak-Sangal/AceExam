package com.acexams.aceexam.retrofit


import com.acexams.aceexam.Model.GetProfileResponse
import com.acexams.aceexam.Model.SignupResponse
import com.acexams.aceexam.Model.UpdateProfileResponse
import com.acexams.aceexam.activity.modal.*
import com.acexams.aceexam.bookmark.ReviewRatingModal
import com.acexams.aceexam.mcqbookmark.modal.BookMarkListModal
import com.acexams.aceexam.progresstracker.modal.ProgressBarModal
import com.acexams.aceexam.questiobank.adpater.slideResponse
import com.acexams.aceexam.questiobank.modal.*
import com.example.aceexam.activity.modal.VodResponse
import com.example.paytm.RankingResponseModal
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {

    @POST("signup")
    fun signup(
        @Body hashMap: HashMap<String, String>
    ): Call<SignupResponse>


    @POST("sendSms")
    fun sendotp(
        @Body hashMap: HashMap<String, String>
    ): Call<SendotpRespone>


    @POST("validateOTP")
    fun otpverified(
        @Body hashMap: HashMap<String, String>
    ): Call<SendotpRespone>

    @POST("generateChecksum.php")
    fun paytmchecksum(
        @Body hashMap: HashMap<String, String>
    ): Call<PaytmResponse>


    @POST("forgotPasswordValidateOTP")
    fun forgotPasswordValidateOTP(
        @Body hashMap: HashMap<String, String>
    ): Call<SendotpRespone>

    @POST("forgotPasswordSendSms")
    fun forgotPasswordSendSms(
        @Body hashMap: HashMap<String, String>
    ): Call<SendotpRespone>


    @POST("signin")
    fun login(
        @Body hashMap: HashMap<String, String>
    ): Call<ResponseBody>

    @GET("fetch_subscription")
    fun plan(@Header("Authorization") token: String?): Call<PlanResponse>


    @GET("search")
    fun search(@Header("Authorization") token: String?,
         @Query("keyword") keyword: String): Call<SearchResponse>

    @POST("exam-of-day")
    fun examof(@Header("Authorization") token: String
              ): Call<examoftheday>

    @FormUrlEncoded
    @POST("all_pearls")
    fun allpearls(
        @Header("Authorization") token: String?,
        @Field("user_id") user_id: String?
    ): Call<AllperalResponse>


    @FormUrlEncoded
    @POST("contact-us-email")
    fun contact(
        @Header("Authorization") token: String?,
        @Field("user_id") user_id: String?,
        @Field("message") message: String?

    ): Call<AllperalResponse>


    @FormUrlEncoded
    @POST("dashboard-percent")
    fun progresstracker(
        @Header("Authorization") token: String?,
        @Field("user_id") user_id: String?
    ): Call<ProgressTrackerResponse>


    @GET("examslist")
    fun examslist(): Call<ExamsList>

    @FormUrlEncoded
    @POST("all_tests")
    fun testexam(
        @Header("Authorization") token: String?,
        @Field("type") type: String?,
        @Field("user_id") user_id: String?
    ): Call<TestexamResponse>

    @FormUrlEncoded
    @POST("verifyEmail")
    fun verifyEmail(
        @Field("email") name: String?,
        @Field("password") email: String?
    ): Call<ResponseBody>

    @FormUrlEncoded
    @POST("test/question")
    fun questiion(
        @Header("Authorization") token: String?,
        @Field("test_id") id: String?,
        @Field("user_id") user_id: String?
    ): Call<QuestionModals>


    @FormUrlEncoded
    @POST("video/detail")
    fun videodetails(
        @Header("Authorization") token: String?,
        @Field("id") id: String?,
        @Field("user_id") user_id: String?
    ): Call<VideoResponse>

    @FormUrlEncoded
    @POST("custom/test")
    fun custom(
        @Header("Authorization") token: String?,
        @Field("no_question") no_question: String?,
        @Field("user_id") user_id: String?
    ): Call<QuestionModals>

    @Multipart
    @POST("test/submit")
    fun submit(
        @Header("Authorization") token: String?,
        @PartMap map: MutableMap<String, RequestBody>
    ): Call<ResponseBody>


    @Multipart
    @POST("submit/topic/exam")
    fun questionbanksumit(
        @Header("Authorization") token: String?,
        @PartMap map: MutableMap<String, RequestBody>
    ): Call<ResponseBody>

    @Multipart
    @POST("custom/test/submit")
    fun customsumit(
        @Header("Authorization") token: String?,
        @PartMap map: MutableMap<String, RequestBody>
    ): Call<ResponseBody>

    @FormUrlEncoded
    @POST("change_password")
    fun change_password(
        @Field("email") name: String?,
        @Field("password") email: String?
    ): Call<ChangePasswordResponse>

    @FormUrlEncoded
    @POST("collagelist")
    fun getcollge(
        @Field("state_id") state_id: String?,
    ): Call<CollegeResponse>


    @GET("studentCourses")
    fun getcourse(
        @Header("Authorization") token: String?,
    ): Call<CourseResponse>

    @FormUrlEncoded
    @POST("weekly-tracker")
    fun getTracker(
        @Field("user_id") token: String?,
        @Field("date_of_completion ") date_of_completion : String?
    ): Call<ProgressBarModal>

    @FormUrlEncoded
    @POST("question-bookmark-list")
    fun bookmark_list(
        @Field("user_id") id: String,
    ): Call<BookMarkListModal>


    @GET("statelist")
    fun states(
    ): Call<StateResponse>


    @GET("mcq")
    fun mqcoftheday(
        @Header("Authorization") token: String?,
    ): Call<ModResponse>

    @FormUrlEncoded
    @POST("courseChapters")
    fun subject(
        @Header("Authorization") token: String?,
        @Field("id") id: String
    ): Call<SubjectResponse>


    @FormUrlEncoded
    @POST("test-ranking")
    fun topranikg(
        @Header("Authorization") token: String?,
        @Field("test_id") test_id: String
    ): Call<RankingResponseModal>

    @FormUrlEncoded
    @POST("question-bookmark")
    fun bookMark(
        @Field("question_id") token: String,
        @Field("user_id") test_id: String,
        @Field("status") status: String
    ): Call<ResponseBody>


    @FormUrlEncoded
    @POST("video-bookmark")
    fun videobookmark(
        @Field("video_id") video_id: String,
        @Field("user_id") test_id: String,
        @Field("status") status: String
    ): Call<VideoBookmarkResponse>

    @FormUrlEncoded
    @POST("pearl-bookmark")
    fun perlbookmark(
        @Field("video_id") token: String,
        @Field("user_id") test_id: String,
        @Field("status") status: String
    ): Call<ResponseBody>


    @FormUrlEncoded
    @POST("chapterVideos")
    fun video(
        @Header("Authorization") token: String?,
        @Field("id") id: String,
        @Field("user_id") user_id: String?,
    ): Call<VideoListResponse>


    @FormUrlEncoded
    @POST("get/bookmark")
    fun bookmark(
        @Header("Authorization") token: String?,
        @Field("video_id") video_id: String
    ): Call<BookmarkResponse>

    @Multipart
    @POST("updateProfile")
    fun updateProfile(
        @Header("Authorization") token: String?,
        @Part("id") id: RequestBody,
        @Part("name") name: RequestBody,
        @Part("email") email: RequestBody,
        @Part("mobile") mobile: RequestBody,
        @Part("remove_image") remove_image:RequestBody,
        @Part image: MultipartBody.Part?
    ): Call<UpdateProfileResponse>

    /* @Multipart
     @POST("update")
     fun updateprofile(
             @Header("Authorization") token: String?,
             @Part("id") name: RequestBody?,
             @Part("name") address: RequestBody?,
             @Part("email") mobile: RequestBody?,
             @Part("location") location: RequestBody?,
             @Part image: MultipartBody.Part?
     ): Call<ResponseBody?>?*/

    @FormUrlEncoded
    @POST("getProfile")
    fun getprofile(
        @Header("Authorization") token: String?,
        @Field("id") id: String?
    ): Call<GetProfileResponse>

    @FormUrlEncoded
    @POST("over-all-progress-subject-wise")
    fun overalll(
        @Header("Authorization") token: String?,
        @Field("user_id") user_id: String?
    ): Call<OverAllProcessResponse>

    @FormUrlEncoded
    @POST("update-exam")
    fun update_exam(
        @Field("user_id") user_id: String,
        @Field("exam_id") exam_id: String
    ): Call<ResponseBody>

    @FormUrlEncoded
    @POST("findUniqueEmailId")
    fun matchemail(
        @Field("email") name: String?,
    ): Call<EmailVerifiyResponse>


    @FormUrlEncoded
    @POST("notes")
    fun Notes(
        @Header("Authorization") token: String?,
        @Field("video_id") video_id: String?,
    ): Call<NotesResponse>


    @FormUrlEncoded
    @POST("slides")
    fun slides(
        @Header("Authorization") token: String?,
        @Field("video_id") video_id: String?,
    ): Call<slideResponse>

    @GET("fetch-video")
    fun vod(
        @Header("Authorization") token: String?,
    ): Call<VodResponse>


    @GET("faculty_list")
    fun faclities(
        @Header("Authorization") token: String?,
    ): Call<FacalityResponse>

    @FormUrlEncoded
    @POST("test/review")
    fun reviewdetails(
        @Header("Authorization") token: String?,
        @Field("test_id") test_id: String?,
        @Field("user_id") user_id: String?,
    ): Call<ReviewDetailModal>


    @FormUrlEncoded
    @POST("generateChecksum.php")
    fun getcheckSum(
        @Field("MID") mid: String?,
        @Field("ORDER_ID") order_id: String?,
        @Field("CUST_ID") custom_id: String?,
        @Field("MOBILE_NO") mobileNo: String?,
        @Field("EMAIL") email: String?,
        @Field("CHANNEL_ID") channel_id: String?,
        @Field("WEBSITE") website: String?,
        @Field("TXN_AMOUNT") amount: String?,
        @Field("INDUSTRY_TYPE_ID") indu: String? //   @Field("CALLBACK_URL") String callBack
    ): Call<ResponseBody>


    @FormUrlEncoded
    @POST("subject_list")
    fun subjectList(
        @Header("Authorization") token: String?,
        @Field("id") id: String
    ): Call<SubjectListModal>

    @FormUrlEncoded
    @POST("topic_list")
    fun subjectTopicList(
        @Header("Authorization") token: String?,
        @Field("id") id: String
    ): Call<SubjectTopicModal>

    @Multipart
    @POST("custom/test")
    fun customTest(
        @HeaderMap token: Map<String, String>,
        @PartMap params: MutableMap<String, RequestBody>,
    ): Call<QuestionBankTestListModal>



    @FormUrlEncoded
    @POST("submit_rating")
    fun reviewandrating(
        @Header("Authorization") token: String?,
        @Field("user_id") user_id: String,
        @Field("video_id") video_id: String,
        @Field("rating") rating: String,
        @Field("review") review: String
    ): Call<ReviewRatingModal>


    @FormUrlEncoded
    @POST("topic/examlist")
    fun Questionbank(
        @Header("Authorization") token: String?,
        @Field("topic_id") topic_id: String,
        @Field("user_id") test_id: String,
    ): Call<QuestiontestResponse>

    @FormUrlEncoded
    @POST("subjects")
    fun questionbankquestio(
        @Header("Authorization") token: String?,
        @Field("topic_id") topic_id: String,
        @Field("user_id") test_id: String,
    ): Call<QbanksubjectResponse>



    @FormUrlEncoded
    @POST("video-status")
    fun makecompeted(
        @Field("video_id") video_id: String,
        @Field("user_id") test_id: String,
        @Field("status") status: String
    ): Call<ResponseBody>


    @FormUrlEncoded
    @POST("subject_wise_pearls")
    fun subjectwiseperl(
        @Header("Authorization") token: String?,
        @Field("subject_id") subject_id: String,
    ): Call<ResponseBody>

    @GET
    @Streaming
    fun downloadImage(@Url fileUrl: String?): Call<ResponseBody>

}


