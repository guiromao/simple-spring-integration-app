package co.trucom.simplespringintegrationapp.services;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class IntegrationService {

	@ServiceActivator(inputChannel = "integration.gateway.channel")
	public void handleMessage(Message<String> message) throws MessagingException {
		MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
		MessageBuilder.fromMessage(message);
		Message<String> replyMessage = MessageBuilder
				.withPayload("Saying 'hello' from this message, " + message.getPayload() + "!!!")
				.build();
		replyChannel.send(replyMessage);
	}

}
