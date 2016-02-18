import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterMessageTest {
	TwitterMessage myMessage;
	TwitterMessage myMessage1;
	TwitterMessage myMessage2;
	TwitterMessage myMessage3;
	Utilities myUtility;
	@Before
	public void setUp() throws Exception {
		myMessage = new TwitterMessage("@franky goes to #hollywood See http://cnn.com");
		myMessage1 = new TwitterMessage("#@test this tweet is a @#test");
		myMessage2 = new TwitterMessage("@mentionmentionmentionmentionmentionmentionmention #topic**((&#(@#&");
		myMessage3 = new TwitterMessage("@michael @tommy @#@myname)--0 hello %4@@@ @michael. http://github.com github.com http:facebook.com");
		
		myUtility = new Utilities();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TwitterMessageTest(){
		assertTrue(myMessage.getTweetText() == "@franky goes to #hollywood See http://cnn.com");
		assertEquals(myMessage.getWords().get(3), "#hollywood");
		assertEquals(myMessage1.getWords().get(3), "is");
		assertEquals(myMessage2.getWords().get(1), "#topic**((&#(@#&");
		assertTrue(myMessage.getDate() != null);
	}
	
	@Test
	public void WordsTest(){
		assertTrue(myMessage.getWords().size() == 6);
		assertTrue(myMessage3.getWords().size() == 9);
		assertTrue(myMessage2.getWords().size() == 2);
		assertTrue(myMessage1.getWords().size() == 6);
		assertEquals(myMessage.getWords().get(2), "to");
	}
	
	@Test
	public void MentionsTest() {
		assertEquals("@franky", myMessage.getMentions().get(0));
		assertTrue(1 == myMessage.getMentions().size());
	}
	@Test
	public void LinksTest(){
		assertEquals("http://cnn.com", myMessage.getLinks().get(0));
		assertTrue(myUtility.pingUrl(myMessage.getLinks().get(0)));
		assertFalse(myUtility.pingUrl("htp://google.com"));
		myMessage.addLink("http://facebook.com");
		assertTrue(myUtility.pingUrl("http://facebook.com"));
		assertTrue(myMessage.getLinks().get(1) == "http://facebook.com");
	}
	@Test
	public void HashtagsTest(){
		assertEquals(myMessage.getHashTags().get(0), "#hollywood");
	}

}
