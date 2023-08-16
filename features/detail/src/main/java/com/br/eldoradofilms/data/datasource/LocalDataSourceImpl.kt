package com.br.eldoradofilms.data.datasource

import androidx.room.Room

class LocalDataSourceImpl(
    private val localDB: Room
) : LocalDataSource {
    override suspend fun savePreferred() {
        TODO("Not yet implemented")
    }

    override suspend fun getPreferred() {
        TODO("Not yet implemented")
    }

    override suspend fun getRelated() {

    }
}
