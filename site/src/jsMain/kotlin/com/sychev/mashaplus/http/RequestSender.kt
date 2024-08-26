package com.sychev.mashaplus.http

import org.w3c.xhr.XMLHttpRequest

object RequestSender {

    private val CHAT_IDS = listOf("903452317", "384321487")

    fun sendTgMessage(message: String, onSuccess: () -> Unit = {}, onError: () -> Unit = {}) {
        var successCount = 0
        CHAT_IDS.forEach { chatId ->
            val request = XMLHttpRequest()
            request.open(
                method = "POST",
                url = "https://api.telegram.org/bot6747408655:AAHvT-xv4z88R6PFeZPG03TV6y4jQkVJHtY/sendMessage",
                async = true
            )
            request.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
            request.addEventListener(
                "load",
                {
                    if (request.readyState == 4.toShort()) {
                        if (request.status == 200.toShort()) {
                            successCount++
                        }
                    }
                }
            )
            request.send(
                """{"chat_id":$chatId, "text":"$message"}"""
            )
        }
        if (successCount == CHAT_IDS.size) {
            onSuccess.invoke()
        } else {
            onError.invoke()
        }
    }

}