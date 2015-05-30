package dependencyInjection;

public class SMSServiceInjector implements ServiceInjector {

	@Override
	public ConsumerOfService getConsumer() {
		
		return new MyApplication(new SMSService());
	}

}
