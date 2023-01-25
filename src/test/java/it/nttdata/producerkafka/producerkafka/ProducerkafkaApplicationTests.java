package it.nttdata.producerkafka.producerkafka;

import it.nttdata.producerkafka.producerkafka.service.SendMessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProducerkafkaApplicationTests {

	@Autowired
	private SendMessageService sendMessageService;

	@Test
	void contextLoads() {
	}

	@Test
	void sendMessageTest(){
		sendMessageService.sendMessage("Ciao mondo");
	}
	@Test
	void sendMessageTest2(){
		sendMessageService.sendMessage2("Ciao mondo2");
	}

}
