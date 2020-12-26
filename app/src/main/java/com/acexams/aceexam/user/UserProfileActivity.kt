package com.acexams.aceexam.user

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.acexams.aceexam.Model.GetProfileResponse
import com.acexams.aceexam.Model.UpdateProfileResponse
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.ChangePasswordActivity
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.setting.SettingActivity
import com.app.politciannewapp.utils.MyProgressDialog
import com.squareup.picasso.Picasso
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_user_profile.*
import kotlinx.android.synthetic.main.fragment_home_fragement.*
import kotlinx.android.synthetic.main.fragment_video_classes.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import shareprefrences
import java.io.*
import java.util.regex.Pattern

class UserProfileActivity : AppCompatActivity(), View.OnClickListener {

    var file: File? = null
    var sendemail=""
    lateinit var token: String
    val RECORD_REQUEST_CODE = 101
    var imageUriSign: Uri? = null
    var mFilePathSign = ""
    var img_salon: ImageView? = null
    var profile_image = ""
    var picname: String? = null
    var profileimageString: String? = null
    lateinit var id: String
    private val TAG = "PermissionDemo"
    lateinit var name: String
    lateinit var email: String
    lateinit var mobile:String
    var removeimage_value="0"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )
        id = shareprefrences.getStringPreference(this, "USER_ID").toString()
        token = shareprefrences.getStringPreference(this, "ACCESS_TOKEN").toString()
        Log.e("id", id.toString())
        Log.e("token", token.toString())
        // token="Bearer"+"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hY2V4YW0uY29tXC9hcGlcL3N0dWRlbnRcL3NpZ25pbiIsImlhdCI6MTYwNTE3Nzg1NCwiZXhwIjoxNjQxMTc3ODU0LCJuYmYiOjE2MDUxNzc4NTQsImp0aSI6InB4dEVVRTVFYk9LZW9PMDkiLCJzdWIiOjUzLCJwcnYiOiI4N2UwYWYxZWY5ZmQxNTgxMmZkZWM5NzE1M2ExNGUwYjA0NzU0NmFhIn0.SUhnD5hlrhHBXIob15JceMSXvUDy0o-bRXoLJGxaYms"

//        editpicture.setOnClickListener(this);
        profile();
        save.setOnClickListener(this);
//        backbutoon.setOnClickListener {
//            onBackPressed()
//        }


        changepicture.setOnClickListener {
            picname = "profilepic"
            if (checkpermission()!!) {
                selectImage(this)
            } else {
                setupPermissions()
            }
        }
        txt_change_password.setOnClickListener {
            startActivity(Intent(this, ChangePasswordActivity::class.java).putExtra("emmail",sendemail))
        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
//            R.id.editpicture -> {
//                CropImage.activity()
//                    .setGuidelines(CropImageView.Guidelines.ON)
//                    .start(this);
//            }
            R.id.save -> {
                validation()
            }
        }
    }


    /* override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         super.onActivityResult(requestCode, resultCode, data)
         if (requestCode === CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
             val result = CropImage.getActivityResult(data)
             if (resultCode === RESULT_OK) {
                 val resultUri: Uri = result.uri
                 val path = resultUri.toString()
                 file = File(URI(path))
                 Glide.with(this)
                         .load(resultUri) // Uri of the picture
                         .into(profile_image);
             } else if (resultCode === CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                 val error = result.error
             }
         }

     }*/


    //=============Image take================

    //=============Image take================
    private fun selectImage(context: Context) {
        val options = arrayOf<CharSequence>("Take Photo", "Choose from Gallery", "Cancel","Remove Picture")
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Choose your profile picture")
        builder.setItems(options) { dialog, item ->
            if (options[item] == "Take Photo") {
                val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(takePicture, 0)
            } else if (options[item] == "Choose from Gallery") {
                val pickPhoto =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(pickPhoto, 1)
            } else if (options[item] == "Cancel") {
                dialog.dismiss()
            }else if (options[item] == "Reset Picture") {
                imageView.setImageResource(R.drawable.profile)
                dialog.dismiss()
                removeimage_value="1"
                validation()
            }
        }
        builder.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_CANCELED) {
            when (requestCode) {
                0 ->                    /* if (resultCode == RESULT_OK && data != null) {
                        Bitmap selectedImage = (Bitmap) data.getExtras().get("data");
                        Log.e("iamgepath", selectedImage.toString());
                        imageView.setImageBitmap(selectedImage);
                        file = new File(selectedImage.toString());
                        Log.e("file", file.toString());


                    }*/
                    if (data != null) {
                        val thumbnail = data.extras!!["data"] as Bitmap?
                        val bytes = ByteArrayOutputStream()
                        val destination = File(
                            Environment.getExternalStorageDirectory(),
                            System.currentTimeMillis().toString() + ".jpg"
                        )
                        val fo: FileOutputStream
                        try {
                            try {
                                destination.createNewFile()
                                fo = FileOutputStream(destination)
                                fo.write(bytes.toByteArray())
                                fo.close()
                            } catch (e: IOException) {
                                e.printStackTrace()
                            }
                            imageUriSign = getImageUri(this, thumbnail)
                            mFilePathSign = getAbsolutePath(imageUriSign)
                            Log.e("paths", mFilePathSign)
                            Toast.makeText(this, "Image Saved!", Toast.LENGTH_SHORT).show()
                            if (picname == "profilepic") {
                                imageView.setImageBitmap(thumbnail)
                                //  profile_image.setImageBitmap(thumbnail)
                                val baos = ByteArrayOutputStream()
                                thumbnail!!.compress(Bitmap.CompressFormat.JPEG, 100, baos)
                                val images = baos.toByteArray()
                                // Log.e("imageses",images.toString())
                                profileimageString = Base64.encodeToString(images, Base64.DEFAULT)
                            }
                            //  Log.e("image", profileimageString.toString())
                        } catch (e: Exception) {
                        }

                    }
                1 ->

                    /*  if (resultCode == RESULT_OK && data != null) {
                        Uri selectedImage = data.getData();
                        String[] filePathColumn = {MediaStore.Images.Media.DATA};
                        if (selectedImage != null) {
                            Cursor cursor = getContentResolver().query(selectedImage,
                                    filePathColumn, null, null, null);
                            if (cursor != null) {
                                cursor.moveToFirst();

                                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                                String picturePath = cursor.getString(columnIndex);
                                Log.e("iamgepath", picturePath);
                                file = new File(picturePath);
                                Log.e("filepath", file.toString());
                                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                                cursor.close();
                            }
                        }

                    }*/
                    try {
                        imageUriSign = data!!.data
//                        val imageStream4: InputStream =
//                            this.contentResolver.openInputStream(imageUriSign!!)!!
//                        val selectedImage4 = BitmapFactory.decodeStream(imageStream4)
//                        val selectedImageUri = data.data
//                        val filePath = arrayOf(MediaStore.Images.Media.DATA)
//                        val cursor = contentResolver.query(
//                            selectedImageUri!!,
//                            filePath, null, null, null
//                        )
//                        cursor!!.moveToFirst()
//                        val columnIndex = cursor.getColumnIndex(filePath[0])
//                        mFilePathSign = cursor.getString(columnIndex)
//                        Log.e("paths", mFilePathSign)
//                        cursor.close()
                        imageView.setImageURI(imageUriSign)

                        // imageView.tag = "profile";
                    } catch (e: IOException) {
                        e.printStackTrace()
                        Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }

    fun getImageUri(inContext: Context, inImage: Bitmap?): Uri {
        val bytes = ByteArrayOutputStream()
        inImage!!.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path =
            MediaStore.Images.Media.insertImage(inContext.contentResolver, inImage, "Title", null)
        return Uri.parse(path)
    }

    fun getAbsolutePath(uri: Uri?): String {
        var cursor: Cursor? = null
        return try {
            val proj = arrayOf(MediaStore.Images.Media.DATA)
            cursor = this.getContentResolver().query(uri!!, proj, null, null, null)
            val column_index = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            cursor.moveToFirst()
            cursor.getString(column_index)
        } finally {
            cursor?.close()
        }
    }

    ///===============Check Permission============
    fun checkpermission(): Boolean? {
        val camerapermission =
            (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    + ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
                    + ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA))
        return camerapermission == PackageManager.PERMISSION_GRANTED
    }

    fun setupPermissions() {
        val permissions =
            (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    + ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
                    + ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA))
        if (permissions != PackageManager.PERMISSION_GRANTED) {

            makeRequest()
        }
    }

    fun makeRequest() {
        ActivityCompat.requestPermissions(
            this, arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ), RECORD_REQUEST_CODE
        )
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            RECORD_REQUEST_CODE -> {
                if (grantResults.size > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {
                    // Permission is granted. Continue the action or workflow
                    // in your app.
                    Log.i(TAG, "Permission has been granted by user")
                } else {
                    // Explain to the user that the feature is unavailable because
                    // the features requires a permission that the user has denied.
                    // At the same time, respect the user's decision. Don't link to
                    // system settings in an effort to convince the user to change
                    // their decision.
                    Log.i(TAG, "Permission has been denied by user")
                }
                return
            }
        }
    }

    fun validation() {
        name = edt_name.text.toString().trim()
        email = edt_email.text.toString().trim()
        mobile=phone.text.toString().trim()
        if (name.isEmpty()) {
            Toast.makeText(this, "Please Enter Name", Toast.LENGTH_LONG).show()
        } else if (!isValid(email)) {
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_LONG).show()
        }
        else if (mobile.isEmpty()) {
            Toast.makeText(this, "Please Enter Mobile", Toast.LENGTH_LONG).show()
        } else if (mobile.length!=10) {
            Toast.makeText(this, "Please Enter Vaild Mobile Number", Toast.LENGTH_LONG).show()
        }
        else {
            update()
        }
    }

    fun isValid(email: String?): Boolean {
        val emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$"
        val pat = Pattern.compile(emailRegex)
        return if (email == null) false else pat.matcher(email).matches()
    }

    fun update() {
        MyProgressDialog.showProgress(this)
        val multiPartRepeatString = "application/image"
        var facility_image: MultipartBody.Part? = null
        val update_id: RequestBody = RequestBody.create(MultipartBody.FORM, id)
        val name_update: RequestBody = RequestBody.create(MultipartBody.FORM, name)
        val name_mobile: RequestBody = RequestBody.create(MultipartBody.FORM, mobile)
        val remove_image: RequestBody = RequestBody.create(MultipartBody.FORM, removeimage_value)
        val update_Email: RequestBody =
            RequestBody.create(MultipartBody.FORM, edt_email.text.toString().trim())
        if (imageUriSign != null && imageUriSign!!.path != null) {
            val file = File(getPath(imageUriSign))
            val signPicBody = RequestBody.create(multiPartRepeatString.toMediaTypeOrNull(), file)
            facility_image = MultipartBody.Part.createFormData("image", file.name, signPicBody)
        }
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.updateProfile(
            "Bearer" + token,
            update_id,
            name_update,
            update_Email,
            name_mobile,
            remove_image,
            facility_image,


        )
        call.enqueue(object : Callback<UpdateProfileResponse> {
            override fun onResponse(
                call: Call<UpdateProfileResponse>, response: Response<UpdateProfileResponse>) {
                MyProgressDialog.dismissProgress()
                if(response.code()==200) {
                    if (response.body()?.staus == 200) {
                        Toast.makeText(
                            this@UserProfileActivity,
                            "Updated Profile",
                            Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@UserProfileActivity, SettingActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(
                            this@UserProfileActivity,
                            response.body()!!.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }else if(response.code()==401){
                    Toast.makeText(this@UserProfileActivity,
                        "Data Already Exist",
                        Toast.LENGTH_SHORT
                    ).show()
                }


            }

            override fun onFailure(call: Call<UpdateProfileResponse>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                Toast.makeText(this@UserProfileActivity, "invalid credentials", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }


    private fun profile() {
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.getprofile(
            "Bearer" + token,
            id
        )
        call.enqueue(object : Callback<GetProfileResponse> {
            override fun onResponse(
                call: Call<GetProfileResponse>,
                response: Response<GetProfileResponse>
            ) {
                try {
                    if (response.code() == 200) {
                        sendemail=response.body()!!.data.email
                        edt_name.setText(response.body()!!.data.name)
                        edt_email.setText(response.body()!!.data.email)
                        phone.setText(response.body()!!.data.mobile)
                        tv_college.setText(response.body()!!.data.collegeName)
                        tv_year.setText(response.body()!!.data.year)
                        var image = response.body()!!.data.image
                        var const = "http://www.acexam.com/web/public/uploads/students/profile/"
                        if (image.isNotEmpty()) {
                            Picasso.get().load(const + image)
                                .into(imageView)
                        }
                    }
                } catch (e: Exception) {
                    Log.e("error", e.toString())
                }
            }

            override fun onFailure(call: Call<GetProfileResponse>, t: Throwable) {
                Toast.makeText(this@UserProfileActivity, "invalid credentials", Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }

    fun getPath(uri: Uri?): String? {
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(uri!!, projection, null, null, null) ?: return null
        val column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        val s = cursor.getString(column_index)
        cursor.close()
        return s
    }


}