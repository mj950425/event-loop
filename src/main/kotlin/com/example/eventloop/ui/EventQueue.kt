package com.example.eventloop.ui

import com.example.eventloop.event.Event
import org.springframework.stereotype.Component
import java.util.concurrent.ArrayBlockingQueue

@Component
class EventQueue : EventStore {
    companion object {
        val blockingQueue = ArrayBlockingQueue<Event>(10)
    }

    override fun save(event: Event) {
        blockingQueue.put(event)
    }

    override fun get(): Event? {
        return blockingQueue.poll()
    }
}