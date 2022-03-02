package com.shihab.friends.di

import android.app.Application
import android.content.Context
import com.shihab.friends.BuildConfig
import com.shihab.friends.network.UserInterface
import com.shihab.friends.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    private val apiURL = if (BuildConfig.DEBUG) {
        "https://randomuser.me/"
    } else {
        "GIVE_YOUR_LINK"
    }

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    fun provideApiURL(): String {
        return apiURL
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return loggingInterceptor
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) = if (BuildConfig.DEBUG) {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        apiURL: String
    ): Retrofit = Retrofit.Builder().baseUrl(apiURL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): UserInterface = retrofit.create(UserInterface::class.java)

    @Singleton
    @Provides
    fun provideNoteRepository(userInterface: UserInterface): UserRepository {
        return UserRepository(userInterface)
    }
}