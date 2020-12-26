package com.talkingtb.talkingtb.remote


import com.acexams.aceexam.retrofit.Constants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Initialise Retrofit Network lib
 */
object ApiClient {
    private var retrofit: Retrofit? = null
    fun getClient(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val gson = GsonBuilder()
            .setLenient()
            .create()
        val client = OkHttpClient.Builder()
            .connectTimeout(200, TimeUnit.SECONDS)
            .writeTimeout(200, TimeUnit.SECONDS)
            .readTimeout(200, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(Constants.BaseUrlNewlive)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
        }
        return retrofit as Retrofit
    }


}


