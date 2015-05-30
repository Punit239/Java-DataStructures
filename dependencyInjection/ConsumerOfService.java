package dependencyInjection;

public interface ConsumerOfService {
	
	public void processMessages(String sentTo, String sentBy);

}
