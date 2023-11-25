package com.blerify.streamtrades.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface StreamTradeService {
    void trade(JsonNode payload);
}
