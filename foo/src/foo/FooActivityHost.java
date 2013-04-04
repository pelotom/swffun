package foo;

import static foo.Util.*;

import com.amazonaws.services.simpleworkflow.flow.ActivityWorker;

public class FooActivityHost {
	public static void main(final String[] args) throws Throwable {
		final ActivityWorker worker = new ActivityWorker(createSwfClient(), DOMAIN, TASK);
		worker.setRegisterDomain(true);
		worker.setDomainRetentionPeriodInDays(1);
		worker.addActivitiesImplementation(new FooActivitiesImpl());
		worker.start();
	}
}
