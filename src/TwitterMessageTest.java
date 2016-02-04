import static org.junit.Assert.*;

import java.util.ArrayList;
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
	public void TwitterMessageTest(){
		assertTrue(myMessage.getTweetText() == "@franky goes to #hollywood. See http://cnn.com");
	}
	
	@Test
	public void Mentionstest() {
		assertEquals("@franky", myMessage.getMentions().get(0));
		assertEquals(1, myMessage.getMentions().size());
	}
	@Test
	public void LinksTest(){
		return;
	}

}
