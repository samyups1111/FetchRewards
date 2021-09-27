package com.sammydj.fetchrewards.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sammydj.fetchrewards.model.ItemLocal

@Dao
interface MainDao {

    @Query("SELECT * FROM ItemLocal WHERE name <> '' ORDER BY listId asc ")
    fun getItemsFromDB(): LiveData<List<ItemLocal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItemsToDB(vararg shops: ItemLocal)

    @Query("DELETE FROM ItemLocal")
    suspend fun deleteAllItemsFromDB()
}