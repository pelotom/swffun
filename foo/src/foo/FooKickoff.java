package foo;

import static foo.Util.*;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;

public class FooKickoff {
	public static void main(final String[] args) throws Throwable {
		final AmazonSimpleWorkflow swf = createSwfClient();
		final FooWorkflowClientExternalFactory workflowClientFactory = new FooWorkflowClientExternalFactoryImpl(swf, DOMAIN); 
		final FooWorkflowClientExternal workflowClient = workflowClientFactory.getClient(); 
		workflowClient.startFoo();
	}
}
