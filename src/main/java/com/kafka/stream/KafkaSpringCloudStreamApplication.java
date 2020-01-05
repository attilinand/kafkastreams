package com.kafka.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.kafka.stream.binding.BindingConfig;
import com.kafka.stream.model.Opportunity;


@SpringBootApplication
@EnableBinding(BindingConfig.class)
public class KafkaSpringCloudStreamApplication {

		public static void main(String[] args) {
				SpringApplication.run(KafkaSpringCloudStreamApplication.class, args);
		}

		//this component will send the messages to the topic using a scheduler
		@Component
		public static class PageViewEventSource implements ApplicationRunner {

				private final MessageChannel pageViewsOut;
				private final Log log = LogFactory.getLog(getClass());

				public PageViewEventSource(BindingConfig binding) {
						this.pageViewsOut = binding.pageViewsOut();
				}

				@Override
				public void run(ApplicationArguments args) throws Exception {
						List<String> names = Arrays.asList("1", "2", "3", "4", "5");
						List<String> pages = Arrays.asList("blog", "sitemap", "initializr", "news", "about");
						Runnable runnable = () -> {
								String rPage = pages.get(new Random().nextInt(pages.size()));
								String rName = pages.get(new Random().nextInt(names.size()));
								//PageViewEvent pageViewEvent = new PageViewEvent(rName, rPage, Math.random() > .5 ? 10 : 1000);
								Opportunity opportunity = new Opportunity();
								opportunity.setPage(rPage);
								opportunity.setOpportunityId(rName);
								Message<Opportunity> message = MessageBuilder
									.withPayload(opportunity)
									.setHeader(KafkaHeaders.MESSAGE_KEY, opportunity.getOpportunityId().getBytes())
									.build();
								try {
										this.pageViewsOut.send(message);
										log.info("message sent " + message.toString());
								}
								catch (Exception e) {
										log.error(e);
								}
						};
						Executors.newScheduledThreadPool(1).scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
				}
		}

}
	
	