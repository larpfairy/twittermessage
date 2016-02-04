import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterMessageTest {
	TwitterMessage myMessage;
	@Before
	public void setUp() throws Exception {
		myMessage = new TwitterMessage("@franky goes to #hollywood. See http://cnn.com");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TwitterMessagetest() {
		List<String> myMentions = myMessage.getMentions();
	}

}
