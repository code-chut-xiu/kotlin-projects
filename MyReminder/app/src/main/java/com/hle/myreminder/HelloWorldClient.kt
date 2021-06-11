package com.hle.myreminder

import com.hle.myreminder.helloworld.GreeterGrpcKt
import com.hle.myreminder.helloworld.HelloRequest
import io.grpc.ManagedChannel
import kotlinx.coroutines.runBlocking

class HelloWorldClient {
    private val greeter by lazy { GreeterGrpcKt.GreeterCoroutineStub(channel()) }
    private fun channel(): ManagedChannel {

    }
    fun sendRequest(name: String) = runBlocking {
        val request = HelloRequest.newBuilder().setName(name).build()
        val response = greeter.sayHello(request)
    }



}