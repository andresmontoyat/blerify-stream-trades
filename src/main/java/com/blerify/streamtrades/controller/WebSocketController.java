package com.blerify.streamtrades.controller;

import com.blerify.streamtrades.service.StreamTradeService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    private final StreamTradeService streamTradeService;

    public WebSocketController(StreamTradeService streamTradeService) {
        this.streamTradeService = streamTradeService;
    }

   @MessageMapping("/trades")
    public void trades(@Payload JsonNode payload) {
        streamTradeService.trade(payload);
    }
}
