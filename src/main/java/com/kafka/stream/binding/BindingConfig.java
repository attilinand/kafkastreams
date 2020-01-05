package com.kafka.stream.binding;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

import com.kafka.stream.model.Opportunity;

/**
 * 
 * Binding class which is specify the outbound and inbound channel to where messages should be published and consumed
 *
 */
public interface BindingConfig {
	
	String PAGE_VIEWS_OUT = "pvout";
	String PAGE_VIEWS_IN = "pvin";

	// page views
	@Input(PAGE_VIEWS_IN)
	KStream<String, Opportunity> pageViewsIn();

	@Output(PAGE_VIEWS_OUT)
	MessageChannel pageViewsOut();

}
