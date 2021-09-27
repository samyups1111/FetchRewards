package com.sammydj.fetchrewards.model

data class ItemRemote(
    val id: Int?,
    val listId: Int?,
    val name: String?
)

// Separating the domain/database/network models. This can prevent errors.

fun List<ItemRemote>.asDatabaseModel(): List<ItemLocal> {
    return map {
        ItemLocal(
            id = it.id,
            listId = it.listId,
            name = it.name
        )
    }
}
