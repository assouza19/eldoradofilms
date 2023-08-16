package com.br.eldoradofilms.data.datasource

interface LocalDataSource {

    suspend fun savePreferred()
    suspend fun getPreferred()
    suspend fun getRelated()
}