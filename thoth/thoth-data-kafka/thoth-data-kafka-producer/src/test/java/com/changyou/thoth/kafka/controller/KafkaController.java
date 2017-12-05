package com.changyou.thoth.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.changyou.thoth.data.kafka.producer.KafkaProducer;
import com.prometheus.thoth.common.model.RestResult;
import com.prometheus.thoth.common.model.RestResultBuilder;
import com.prometheus.thoth.common.web.controller.BaseController;

/**
 * Created by liangliang on 2017/04/22.
 *
 * @author liangliang
 * @since 2017/04/22
 */
@RestController
@RequestMapping("/admin/demo")
public class KafkaController extends BaseController {

	@Autowired
	KafkaProducer kafkaProducer;

	@SuppressWarnings("rawtypes")
	@PostMapping("/kafka/{topic}")
	public RestResult kafkaProduce(@PathVariable("topic") String topic, @RequestBody String msg) {
		logger.debug("kafkaProduce---> :{}", kafkaProducer);
		logger.debug("getDemo topic:{}, msg:{}", topic, msg);
		kafkaProducer.send(topic, msg);
		return RestResultBuilder.builder().success().build();
	}
}
