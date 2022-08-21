package com.singularity.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author: Singularity
 * @Date: 2022/8/18 11:10
 */
@Component
@EnableBinding(Sink.class)

public class ReceiveMessageController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){

        System.out.println("消费者1号,------>接受到消息:"+message.getPayload()+"\t serverPort:"+ serverPort);
    }
}
