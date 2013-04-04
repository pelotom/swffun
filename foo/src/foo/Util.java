package foo;

import java.io.IOException;

import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;

public class Util {
	
	public static final String DOMAIN = "TestFoo";
	public static final String TASK = "foo";
	
	public static AmazonSimpleWorkflow createSwfClient() throws IOException {
		final PropertiesCredentials creds = new PropertiesCredentials(FooKickoff.class.getResourceAsStream("AwsCredentials.properties"));
		final AmazonSimpleWorkflow swf = new AmazonSimpleWorkflowClient(creds);
		return swf;
	}
}
