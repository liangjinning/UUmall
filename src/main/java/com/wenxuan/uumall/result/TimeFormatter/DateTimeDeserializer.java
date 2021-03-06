package com.wenxuan.uumall.result.TimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    public DateTimeDeserializer() {
    }

    public LocalDateTime deserialize(JsonParser p, DeserializationContext context) throws IOException, JsonProcessingException {
        try {
            return LocalDateTime.parse(p.getText().trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        } catch (Exception var4) {
            return null;
        }
    }
}