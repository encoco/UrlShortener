package com.ticket.service

import org.springframework.stereotype.Service


@Service
class UrlService {
    fun shorten(url : String) : String{
        // 단축된 url return
        // redis에 저장   original : shorten 타입
        println("service $url")
        return ""
    }
    
    
}