package dependencyInjection;

public class EmailServiceInjector implements ServiceInjector {

	@Override
	public ConsumerOfService getConsumer() {
		
		return new MyApplication(new EmailService());
	}

}
