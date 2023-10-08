package com.example.eventloop.handler

import com.example.eventloop.ConsoleOutputUtils.printWithThread
import com.example.eventloop.event.Event
import com.example.eventloop.ui.EventStore
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class AsyncEventListener(
    val eventStore: EventStore
) {

    @Async
    @EventListener
    fun handle(event: Event) {
        printWithThread("${event.message} 처리를 시작합니다.")
        Thread.sleep(10000)
        eventStore.save(Event(isSync = true, message = "${event.message}의 결과를"))
    }
}