package dependencyInjection;

public class MyApplication implements ConsumerOfService {

	MessageService service;
	
	public MyApplication(MessageService service) {
		this.service = service;
	}
	
	@Override
	public void processMessages(String sentTo, String sentBy) {
		
		service.sendMessage(sentTo, sentBy);
	}
}
