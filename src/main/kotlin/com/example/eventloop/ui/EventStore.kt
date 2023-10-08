package com.example.eventloop.ui

import com.example.eventloop.event.Event

interface EventStore {
    fun save(event: Event)

    fun get(): Event?
}