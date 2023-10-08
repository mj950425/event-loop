package com.example.eventloop.ui

import com.example.eventloop.handler.EventHandler
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class Dispatcher(
    val eventStore: EventStore,
    val eventHandler: EventHandler
) {

    @Scheduled(fixedRate = 500)
    fun dispatch() {
        val userEvent = eventStore.get() ?: return
        eventHandler.process(userEvent)
    }
}