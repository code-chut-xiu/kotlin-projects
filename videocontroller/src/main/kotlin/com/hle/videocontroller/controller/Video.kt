package com.hle.videocontroller.controller

import java.util.Objects

class Video {
    private var name: String
        get() = this.name
        set(value) {
            this.name = value
        }
    private var url: String
        get() = this.toString()
        set(value) {
            this.url = value
        }
    private var duration: Long
        get() = this.duration
        set(value) {
            this.duration = value
        }

    constructor(name: String, url: String, duration: Long) {
        this.name = name
        this.url = url
        this.duration = duration
    }

    override fun hashCode(): Int {
        return Objects.hashCode("$name.$url.$duration")
    }

    override fun equals(other: Any?): Boolean {
        return if (other is Video) {
            (Objects.equals(name, other.name)
                    && Objects.equals(url, other.url)
                    && Objects.equals(duration, other.duration))
        } else {
            false
        }
    }
}
