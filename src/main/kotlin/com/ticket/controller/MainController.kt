package com.ticket.controller

import com.ticket.dto.UrlRequestDTO
import com.ticket.dto.UrlResponseDTO
import com.ticket.service.UrlService
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class MainController(
    private val urlService: UrlService,
    private val redisTemplate: RedisTemplate<String, String>
) {

    @GetMapping("/")
    fun test(): String =  "index.html"

    @PostMapping("/urls/shorten")
    fun shorten(@RequestBody request: UrlRequestDTO): UrlResponseDTO {
        return UrlResponseDTO(urlService.shorten(request.originalUrl))
    }

    @GetMapping("/test-redis")
    fun testRedis(): Map<String, String?> {
        return try {
            redisTemplate.opsForValue().set("spring-test", "코프링 Redis 연결 성공! ")
            val value = redisTemplate.opsForValue().get("spring-test")

            mapOf(
                "status" to "SUCCESS",
                "message" to value
            )
        } catch (e: Exception) {
            mapOf(
                "status" to "ERROR",
                "message" to e.message
            )
        }
    }

}