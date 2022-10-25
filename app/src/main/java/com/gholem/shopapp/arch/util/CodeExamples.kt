package com.gholem.shopapp.util

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch

class CodeExamples {

    private val coroutineChannel = Channel<Job>(capacity = Channel.UNLIMITED).apply {
        GlobalScope.launch {
            consumeEach {
                it.join()
            }
        }
    }

    fun getTransactions() {
        coroutineChannel.trySend(GlobalScope.launch(start = CoroutineStart.LAZY) {
        })
    }

    // To Get Data From Google Use: val account = completedTask.getResult(ApiException::class.java)
}