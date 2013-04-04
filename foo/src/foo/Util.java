package foo;

import java.io.IOException;

import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;

public class Util {
	public static AmazonSimpleWorkflow createSwfClient() throws IOException {
		final PropertiesCredentials creds = new PropertiesCredentials(KickoffFoo.class.getResourceAsStream("AwsCredentials.properties"));
		final AmazonSimpleWorkflow swf = new AmazonSimpleWorkflowClient(creds);
		return swf;
	}
}
