package com.example.notificationSystem.config;

import com.example.notificationSystem.dto.NotificationEvent;
import org.apache.kafka.common.TopicPartition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaConsumerConfig {
    @Bean
    public DefaultErrorHandler errorHandler(KafkaTemplate<Object,Object> kafkaTemplate){
        DeadLetterPublishingRecoverer deadLetterPublishingRecoverer = new DeadLetterPublishingRecoverer(kafkaTemplate,
                (record,ex)->new TopicPartition("notification-dlq",record.partition()));
        FixedBackOff backoff = new FixedBackOff(5000L,3);
        return new DefaultErrorHandler(deadLetterPublishingRecoverer,backoff);
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, NotificationEvent> kafkaListenerContainerFactory(ConsumerFactory<String, NotificationEvent> consumerFactory,DefaultErrorHandler errorHandler){
        ConcurrentKafkaListenerContainerFactory<String, NotificationEvent> factory=new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setCommonErrorHandler(errorHandler);
        return factory;

    }
}
