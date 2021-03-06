package com.example.newsfeed.data.network

import android.util.Log
import com.example.newsfeed.data.network.responses.GetArticlesResponse
import com.example.newsfeed.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface API {

    @GET(Constants.ARTICLES_PAGE_API)
    suspend fun getArticles(
        @Query("q") qParam: String,
        @Query("from") fromDate: String,
        @Query("sortBy") sortType: String,
        @Query("apiKey") apiKey: String,
        @Query("page") page: Int
    ): Response<GetArticlesResponse>

    companion object {
        operator fun invoke(networkConnectionInterceptor: NetworkConnectionInterceptor): API {
            Log.e("##API", "created")
            val okHttpClient =
                OkHttpClient.Builder().addInterceptor(networkConnectionInterceptor).build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Constants.BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(API::class.java)
        }
    }
}
