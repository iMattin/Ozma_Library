package com.example.ozma_library

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform