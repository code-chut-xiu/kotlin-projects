package com.hle.videocontroller.client

import com.hle.videocontroller.controller.Video
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

interface VideoSvcApi {
    companion object {
        const val VIDEO_SERVICE_PATH = "/video"
    }

    @GetMapping(VIDEO_SERVICE_PATH)
    public fun getVideoList() : List<Video>

    @PostMapping(VIDEO_SERVICE_PATH)
    public fun addVideo(@RequestBody v: Video) : Boolean
}