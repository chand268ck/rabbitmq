package com.course.rabbitmq1.consumer;

import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQConsumer {
	
	private Logger log = LoggerFactory.getLogger(RabbitMQConsumer.class);

	 @RabbitListener(queues = "courses.fixedrate" , concurrency = "3")
	public void consumeMessage(String messahe)  {
		 log.info("consuming {} on thread {}", messahe,Thread.currentThread().getName());
		System.out.println("consumed message is "+messahe);
		try {
			Thread.sleep(ThreadLocalRandom.current().nextLong(2000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
