package foo;

import static foo.Util.createSwfClient;

import java.io.IOException;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;

public class KickoffFoo {
	public static void main(final String[] args) throws IOException {
		final AmazonSimpleWorkflow swf = createSwfClient();
		final FooWorkflowClientExternalFactory workflowClientFactory = new FooWorkflowClientExternalFactoryImpl(swf, "domain1"); 
		final FooWorkflowClientExternal workflowClient = workflowClientFactory.getClient(); 
		workflowClient.startFoo();
	}
}
