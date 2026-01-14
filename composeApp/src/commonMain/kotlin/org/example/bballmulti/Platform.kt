package org.example.bballmulti

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform