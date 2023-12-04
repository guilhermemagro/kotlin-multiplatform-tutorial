package com.example.kotlinmultiplatformsandbox

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class Greeting {
    private val platform: Platform = getPlatform()
    private val rocketComponent = RocketComponent()

    val daysPhrase = "There are only ${daysUntilNewYear()} days left until New Year! \uD83C\uDF86"

    fun greet(): Flow<String> = flow {
        emit(if (Random.nextBoolean()) "Hi!" else "Hello!")
        delay(1.seconds)
        emit("Guess what it is! > ${platform.name.reversed()}!")
        delay(1.seconds)
        emit(daysPhrase)
        emit(rocketComponent.launchPhrase())
    }
}
