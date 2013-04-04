package foo;

public class FooActivitiesImpl implements FooActivities {

	@Override
	public String getName() {
		return "World";
	}

	@Override
	public void printGreeting(final String greeting) {
		System.out.println(greeting);
	}
}
