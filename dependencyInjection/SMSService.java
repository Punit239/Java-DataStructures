package dependencyInjection;

public class SMSService implements MessageService {

	@Override
	public void sendMessage(String receiver, String sender) {
		
		System.out.println("SMS sent to : " + receiver + " from " + sender);
	}

}
