package com.notification.model.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notification.model.Notificetion;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class NotificationDeserializer implements Deserializer<Notificetion> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Notificetion deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(new String(data), Notificetion.class);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }
}