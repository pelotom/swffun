package foo;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

@Activities(version="1.0")
@ActivityRegistrationOptions(
		defaultTaskScheduleToStartTimeoutSeconds=60,
		defaultTaskStartToCloseTimeoutSeconds=5)
public interface FooActivities {
	public String getName();
	public void printGreeting(String greeting);
}
