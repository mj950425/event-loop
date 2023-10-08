package com.example.eventloop.handler

import com.example.eventloop.ConsoleOutputUtils.printWithThread
import com.example.eventloop.event.Event
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class EventHandler(
    private val publisher: ApplicationEventPublisher
) {

    fun process(event: Event): String {
        if (event.isSync) {
            printWithThread("${event.message}의 결과를 ui 에 그립니다.")
        }

        if (event.isSync.not()) {
            publisher.publishEvent(
                Event(
                    isSync = false,
                    message = event.message
                )
            )
        }

        return "success"
    }
}