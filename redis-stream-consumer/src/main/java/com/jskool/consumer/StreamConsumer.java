package com.jskool.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StreamConsumer implements StreamListener<String, ObjectRecord<String,String >> {
    @Override
    public void onMessage(ObjectRecord<String, String> message) {

        log.info("Consumer subscribes-> {}",message);
        System.out.println(message);
    }
}
