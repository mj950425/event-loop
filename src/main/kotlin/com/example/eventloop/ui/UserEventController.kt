package com.example.eventloop.ui

import com.example.eventloop.ConsoleOutputUtils.printWithThread
import com.example.eventloop.event.Event
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserEventController(
    private val eventStore: EventStore
) {

    @PostMapping
    fun raise(@RequestBody event: Event) {
        printWithThread("${event.message}를 큐에 넣습니다.")
        eventStore.save(event)
    }
}