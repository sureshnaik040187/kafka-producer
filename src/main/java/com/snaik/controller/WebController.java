package com.snaik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.snaik.service.KafkaSender;

@RestController
@RequestMapping(value = "/producer/")
public class WebController {

	@Autowired
	KafkaSender kafkaSender;

	@GetMapping(value = "/{message}")
	public String producer(@PathVariable String message) {
		kafkaSender.send(message);
		return "Message sent to the Kafka Topic Successfully";
	}
}

