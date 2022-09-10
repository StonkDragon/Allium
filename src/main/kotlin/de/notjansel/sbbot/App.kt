/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package de.notjansel.sbbot

import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.utils.env
import de.notjansel.sbbot.extensions.CurrentElection
import de.notjansel.sbbot.extensions.CurrentMayor
import de.notjansel.sbbot.extensions.Startup
import dev.kord.common.entity.Snowflake

val TEST_SERVER_ID = Snowflake(
    env("TEST_SERVER").toLong()  // Get the test server ID from the env vars or a .env file
)

val TEST_SERVER_CHANNEL_ID = Snowflake(
    env("TEST_CHANNEL").toLong() // Get the test channel ID from the env vars or a .env file
)

private val TOKEN = env("TOKEN")   // Get the bot' token from the env vars or a .env file
suspend fun main() {
    val bot = ExtensibleBot(TOKEN) {
        extensions {
            add(::CurrentMayor)
            add(::CurrentElection)
            add(::Startup)
        }
    }

    bot.start()
}
