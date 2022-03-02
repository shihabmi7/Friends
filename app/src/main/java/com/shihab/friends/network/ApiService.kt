package com.shihab.friends.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private var instance: Retrofit? = null
    private var iMyAPI: UserInterface? = null

    private val instancevalue: Retrofit
        get() {
            if (instance == null) {
                instance = Retrofit.Builder().baseUrl("https://randomuser.me/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient())
                   // .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return instance!!
        }

    fun getAPIInterface(): UserInterface {
        if (iMyAPI == null) {
            iMyAPI = instancevalue.create(UserInterface::class.java)
        }
        return iMyAPI!!
    }

    private fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor()) // used if network off OR on
           // .addNetworkInterceptor(StethoInterceptor())
            .build()
    }

    private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
//        val httpLoggingInterceptor =
//            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
//                LogMe.d("Retrofit", "log: http log: $message")
//            })

        val httpLoggingInterceptor = HttpLoggingInterceptor()

        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

}