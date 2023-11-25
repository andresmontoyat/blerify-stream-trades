package com.blerify.streamtrades.service.impl;

import com.blerify.streamtrades.service.StreamTradeService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.lang.NonNull;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class StreamTradeServiceImpl implements StreamTradeService {
    private static final String SYMBOL_KEY = "s";
    private static final String PRICE_KEY = "p";
    private static final String AVERAGE_COMMAND = "BTCUSDT";

    private final Collection<JsonNode> tradeQueue = new ArrayList<>();
    private final SimpMessagingTemplate messagingTemplate;

    public StreamTradeServiceImpl(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void trade(@NonNull JsonNode message) {
        if (AVERAGE_COMMAND.equals(message.get(SYMBOL_KEY).asText())) {
            average();
        } else {
            tradeQueue.add(message);
        }
    }


    @Scheduled(fixedRate = 10000)
    public void average() {
        var result = tradeQueue.stream()
                .mapToDouble(trade -> trade.get(PRICE_KEY).asDouble())
                .average();

        if (result.isPresent())
            messagingTemplate.convertAndSend("/topic/average", result.getAsDouble());
    }
}
