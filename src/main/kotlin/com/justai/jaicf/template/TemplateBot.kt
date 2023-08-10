package com.justai.jaicf.template

import com.justai.jaicf.BotEngine
import com.justai.jaicf.activator.caila.CailaIntentActivator
import com.justai.jaicf.activator.caila.CailaNLUSettings
import com.justai.jaicf.activator.regex.RegexActivator
import com.justai.jaicf.channel.jaicp.logging.JaicpConversationLogger
import com.justai.jaicf.logging.Slf4jConversationLogger
import com.justai.jaicf.template.scenario.mainScenario
import java.util.*

val accessToken: String = System.getenv("JAICP_API_TOKEN") ?: Properties().run {
    load(CailaNLUSettings::class.java.getResourceAsStream("/jaicp.properties"))
    getProperty("apiToken")
}

private val cailaNLUSettings = CailaNLUSettings(
    accessToken = accessToken,
    cailaUrl = "https://jaicp.zfl-stage.lo.test-ai.net/cailapub/api/caila/p"
)

val templateBot = BotEngine(
    scenario = mainScenario,
    conversationLoggers = arrayOf(
        JaicpConversationLogger(accessToken, url = "https://jaicp.zfl-stage.lo.test-ai.net/chatadapter"),
        Slf4jConversationLogger()
    ),
    activators = arrayOf(
        CailaIntentActivator.Factory(cailaNLUSettings),
        RegexActivator
    )
)
