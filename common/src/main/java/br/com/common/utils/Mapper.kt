package com.br.eldoradofilms.utils

interface Mapper<S, T> {
    fun map(source: S): T
}