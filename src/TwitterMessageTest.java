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
		assertTrue(myMessage.getDate() != null);
	}
	
	@Test
	public void WordsTest(){
		assertTrue(myMessage.getWords().size() == 6);
		assertEquals(myMessage.getWords().get(2), "to");
	}
	
	@Test
	public void MentionsTest() {
		assertEquals("@franky", myMessage.getMentions().get(0));
		assertTrue(1 == myMessage.getMentions().size());
		myMessage.addMentions("@Michael");
		assertTrue(2 == myMessage.getMentions().size());
	}
	@Test
	public void LinksTest(){
		assertEquals("http://cnn.com", myMessage.getLinks().get(0));
		assertTrue(myMessage.pingUrl(myMessage.getLinks().get(0)));
		assertFalse(myMessage.pingUrl("htp://google.com"));
		myMessage.addLink("http://facebook.com");
		assertTrue(myMessage.pingUrl("http://facebook.com"));
		assertTrue(myMessage.getLinks().get(1) == "http://facebook.com");
	}

}
