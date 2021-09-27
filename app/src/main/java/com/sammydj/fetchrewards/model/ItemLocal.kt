package com.sammydj.fetchrewards.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemLocal(
    @PrimaryKey
    val id: Int?,
    val listId: Int?,
    val name: String?
)

fun List<ItemLocal>.asDomainModel(): List<Item> {
    return map {
        Item(
            id = it.id,
            listId = it.listId,
            name = it.name
        )
    }
}
