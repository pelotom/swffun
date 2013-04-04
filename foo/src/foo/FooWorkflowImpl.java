package foo;

import com.amazonaws.services.simpleworkflow.flow.annotations.Asynchronous;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;


public class FooWorkflowImpl implements FooWorkflow {
	private static final FooActivitiesClient activitiesClient = new FooActivitiesClientImpl();

	@Override
	public void startFoo() {
		printGreeting(activitiesClient.getName());
	}
	
	@Asynchronous
	public void printGreeting(Promise<String> name) {
		activitiesClient.printGreeting("Hello " + name.get() + "!");
	}
}
