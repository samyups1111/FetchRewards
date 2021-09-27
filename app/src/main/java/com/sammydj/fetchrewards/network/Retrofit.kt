package com.sammydj.fetchrewards.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Retrofit {

    companion object {
        const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val fetchRewardsService: FetchRewardsService = retrofit.create(FetchRewardsService::class.java)
}