package com.example.ozma_library
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class Greeting {
    private val platform: Platform = getPlatform()
    private val client = HttpClient() {
        engine {
            pipelining = true
            threadsCount = 4
        }
    }

    fun greeting(): String {
        return "Hello, ${platform.name}!"
    }

    suspend fun getHtml(): String {
        val response: HttpResponse = client.request("https://gist.githubusercontent.com/sunilshenoy/23a3e7132c27d62599ba741bce13056a/raw/517b07fc382c843dcc7d444046d959a318695245/sample_json.json") {
            method = HttpMethod.Get
        }
        return response.bodyAsText()
    }
}