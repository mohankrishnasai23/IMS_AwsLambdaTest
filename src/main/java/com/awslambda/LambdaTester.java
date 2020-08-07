package com.awslambda;

import java.util.List;

import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;

@Component
public class LambdaTester implements RequestHandler<SQSEvent, String> {

	@Override
	public String handleRequest(SQSEvent input, Context context) {

		System.out.println("message received");

		List<SQSMessage> records = input.getRecords();

		for (SQSMessage record : records) {
			System.out.println(record.getBody());
		}
		return "Success";
	}
}