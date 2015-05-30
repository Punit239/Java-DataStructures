package dependencyInjection;

public class EmailService implements MessageService {

	@Override
	public void sendMessage(String receiver, String sender) {
		
		System.out.println("Email sent to : " + receiver + " from " + sender);
	}

}
