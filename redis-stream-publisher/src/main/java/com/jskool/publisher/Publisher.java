package com.jskool.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.RedisSystemException;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.util.concurrent.atomic.AtomicInteger;
@Component
@RequiredArgsConstructor
@Slf4j
public class Publisher {

    @Value("${stream.key:demo-key}")
    private String streamKey;

    @Autowired
    private RedisTemplate<String, String> template;

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public void streamPublisher(String message) {
        try {
            this.template.opsForList().leftPush(streamKey, message);

        } catch (RedisSystemException e) {
            var cause = e.getCause();
            if (cause != null) {
                log.info("Stream - redis group already exists, skipping redis group creation: {}", streamKey);
            } else throw e;
        }

        atomicInteger.incrementAndGet();
    }
}
