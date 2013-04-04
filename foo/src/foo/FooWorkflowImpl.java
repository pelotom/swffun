package foo;

import com.amazonaws.services.simpleworkflow.flow.annotations.Asynchronous;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;


public class FooWorkflowImpl implements FooWorkflow {
	private static final FooActivitiesClient activitiesClient = new FooActivitiesClientImpl();

	@Override
	public void startFoo() {
		System.out.println("before");
		printGreeting(activitiesClient.getName());
		System.out.println("after");
	}
	
	@Asynchronous
	public void printGreeting(Promise<String> name) {
		System.out.println("inside");
		activitiesClient.printGreeting("Hello " + name.get() + "!");
	}
}
