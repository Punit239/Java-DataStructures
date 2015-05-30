package dependencyInjection;

import java.util.function.Consumer;

public class Demo {

	public static void main(String[] args) {
		
		ServiceInjector injector = new EmailServiceInjector();
		ConsumerOfService app = injector.getConsumer();
		
		app.processMessages("Punit", "SJSU");
		
		injector = new SMSServiceInjector();
		app = injector.getConsumer();
		
		app.processMessages("Neil", "SJSU");

	}

}
