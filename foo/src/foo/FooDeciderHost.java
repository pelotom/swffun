package foo;

import static foo.Util.*;

import com.amazonaws.services.simpleworkflow.flow.WorkflowWorker;

public class FooDeciderHost {
	public static void main(String[] args) throws Throwable {
		final WorkflowWorker worker = new WorkflowWorker(createSwfClient(), DOMAIN, TASK);
		worker.setRegisterDomain(true);
		worker.setDomainRetentionPeriodInDays(1);
		worker.addWorkflowImplementationType(FooWorkflowImpl.class);
		worker.start();
	}
}
