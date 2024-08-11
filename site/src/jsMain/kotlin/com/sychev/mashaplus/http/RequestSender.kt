package com.sychev.mashaplus.http

import org.w3c.xhr.XMLHttpRequest

object RequestSender {

    private const val CHAT_ID = "903452317"

    fun sendTgMessage(message: String, onSuccess: () -> Unit = {}, onError: () -> Unit = {}) {
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
                    if (request.status == 200.toShort())
                        onSuccess.invoke()
                    else
                        onError.invoke()
                }
            }
        )
        request.send(
            """{"chat_id":$CHAT_ID, "text":"$message"}"""
        )

    }

}