package com.rocket.queue.service;

import org.apache.rocketmq.client.producer.SendResult;

public interface FeePlatMqService {
    SendResult openAccountMsg (String msgInfo) ;
}
