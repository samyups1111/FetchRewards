package com.sammydj.fetchrewards.network

import com.sammydj.fetchrewards.model.ItemRemote
import retrofit2.Response
import retrofit2.http.GET

interface FetchRewardsService {

    @GET("hiring.json")
    suspend fun getItemsFromNetwork(): Response<List<ItemRemote>>
}