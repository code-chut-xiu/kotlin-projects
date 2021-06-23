package com.hle.videocontroller.controller

import com.hle.videocontroller.client.VideoSvcApi
import com.hle.videocontroller.client.VideoSvcApi.Companion.VIDEO_SERVICE_PATH
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CopyOnWriteArrayList

@RestController
class VideoSvc : VideoSvcApi {
    private val videos : MutableList<Video> = CopyOnWriteArrayList()

    @RequestMapping(value=[VIDEO_SERVICE_PATH], method = [RequestMethod.POST])
    @ResponseBody override fun addVideo(@RequestBody v: Video): Boolean {
        return videos.add(v)
    }

    @RequestMapping(value=[VIDEO_SERVICE_PATH], method = [RequestMethod.GET])
    @ResponseBody override fun getVideoList(): List<Video> {
        return videos
    }
}