package com.ticket.contoller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class MainController {
    @GetMapping("/")
    fun test(): String {
        println("요청")
        return "index.html"
    }


}