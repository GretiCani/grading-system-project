package com.notification.model.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notification.model.Notification;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class NotificationDeserializer implements Deserializer<Notification> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Notification deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(new String(data), Notification.class);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }
}