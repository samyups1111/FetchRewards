package com.sammydj.fetchrewards

import android.util.Log
import androidx.lifecycle.Transformations
import com.sammydj.fetchrewards.database.MainDao
import com.sammydj.fetchrewards.model.ItemRemote
import com.sammydj.fetchrewards.model.asDatabaseModel
import com.sammydj.fetchrewards.model.asDomainModel
import com.sammydj.fetchrewards.network.FetchRewardsService
import retrofit2.Response

class MainRepository(private val service: FetchRewardsService, private val mainDao: MainDao) {

    fun getItemsFromDatabase() = Transformations.map(mainDao.getItemsFromDB()) {it.asDomainModel()}

    suspend fun getItemsFromNetwork() {

        try {
            val response: Response<List<ItemRemote>> = service.getItemsFromNetwork()
            val itemList = response.body()

            if (itemList != null) {

                val convertedList = itemList.asDatabaseModel().toTypedArray()
                mainDao.insertItemsToDB(*convertedList)

            } else {
                Log.d("TAG", "response = Network list is empty")
            }
        } catch (exception: Exception) {
            Log.d("Tag", "RP exception = " + exception.message.toString())
        }
    }

    suspend fun clearDatabase() = mainDao.deleteAllItemsFromDB()
}