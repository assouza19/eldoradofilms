package com.br.eldoradofilms.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay

fun LifecycleOwner?.postDelay(millis: Long, block: () -> Unit) {
    this?.lifecycleScope?.launchWhenCreated {
        delay(millis)
        block()
    }
}