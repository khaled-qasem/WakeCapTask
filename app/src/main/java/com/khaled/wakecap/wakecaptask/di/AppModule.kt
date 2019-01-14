package com.khaled.wakecap.wakecaptask.di

import com.khaled.wakecap.wakecaptask.BuildConfig
import com.khaled.wakecap.wakecaptask.network.ApiServices
import com.khaled.wakecap.wakecaptask.network.ApisHeadersInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideWakeCapService(okHttpClient: OkHttpClient): ApiServices {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.WAKECAP_DOMAIN)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ApiServices::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
            .addInterceptor(ApisHeadersInterceptor())
        return httpClient.build()
    }
}
