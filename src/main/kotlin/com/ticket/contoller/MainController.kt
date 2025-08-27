package com.ticket.contoller

import com.ticket.dto.UrlRequestDTO
import com.ticket.dto.UrlResponseDTO
import com.ticket.service.UrlService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class MainController(private val urlService: UrlService) {
    @GetMapping("/")
    fun test(): String {
        println("요청")
        return "index.html"
    }

    @PostMapping("/urls/shorten")
    fun shorten(@RequestBody request: UrlRequestDTO): UrlResponseDTO {
        return UrlResponseDTO(urlService.shorten(request.originalUrl))
    }

}