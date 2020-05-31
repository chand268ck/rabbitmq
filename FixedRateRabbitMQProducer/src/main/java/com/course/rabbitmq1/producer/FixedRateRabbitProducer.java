package com.course.rabbitmq1.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FixedRateRabbitProducer {
	@Autowired
	private RabbitTemplate rabbitTemplete;
	private Logger log = LoggerFactory.getLogger(FixedRateRabbitProducer.class);
	private int i=0;

	@Scheduled(fixedRate = 500)
	public void sendHello() {
		log.info("produced {} ", ++i);
		rabbitTemplete.convertAndSend("courses.fixedrate", "Hello world  "+ i);
	}
}
