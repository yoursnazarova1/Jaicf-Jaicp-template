package com.justai.jaicf.template.connections

import com.justai.jaicf.channel.jaicp.JaicpServer
import com.justai.jaicf.channel.jaicp.channels.ChatApiChannel
import com.justai.jaicf.channel.jaicp.channels.ChatWidgetChannel
import com.justai.jaicf.channel.jaicp.channels.TelephonyChannel
import com.justai.jaicf.template.accessToken
import com.justai.jaicf.template.templateBot

fun main() {
    JaicpServer(
        botApi = templateBot,
        accessToken = accessToken,
        channels = listOf(
            ChatApiChannel,
            ChatWidgetChannel,
            TelephonyChannel,
            TelegramChannel (telegabug_bot, "6362470387:AAHOhlUp-cWWOLUPUH8-5xokd-wZUVwnuUE").run()
        ), url = "https://lts-ha01.lo.test-ai.net/chatadapter"
    ).start(wait = true)
}