import java.io.IOException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwitterMessage {
	private String tweetText;
	private List<String> words;
	private List<String> mentions;
	private List<String> links;
	private LocalDateTime dateTime;
	
	public TwitterMessage(String text){
		if(tweetText.isEmpty() || this.tweetText == null){
			tweetText = text;
		}
		dateTime = LocalDateTime.now();
		text = text.trim();
		words = new ArrayList<String>(Arrays.asList(text.split(" ")));
		for(int i = 0; i < words.size(); i++){
			if(words.get(i).charAt(0) == '@'){
				mentions.add(words.get(i));
			}
			if(pingUrl(words.get(i)) == true){
				links.add(words.get(i));
			}
		}
	}
	public TwitterMessage(){
		dateTime = LocalDateTime.now();
	}
	public String getDate(){
		return this.dateTime.toString();
	}
	public void setDate(){
		this.dateTime = LocalDateTime.now();
	}
	public String getTweetText(){
		return tweetText;
	}
	public void setTweetText(String text){
		this.tweetText = text;
	}
	public List<String> getMentions(){
		return mentions;
	}
	public static boolean pingUrl(final String address) {//i found this code on stack overflow, it checks if a string is a valid URL.
		try {
		final URL url = new URL("http://" + address);
		final HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
		urlConn.setConnectTimeout(1000 * 10); // mTimeout is in seconds
		final long startTime = System.currentTimeMillis();
		urlConn.connect();
		final long endTime = System.currentTimeMillis();
		if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
		System.out.println("Time (ms) : " + (endTime - startTime));
		System.out.println("Ping to "+address +" was success");
		return true;
		}
		} catch (final MalformedURLException e1) {
		e1.printStackTrace();
		} catch (final IOException e) {
		e.printStackTrace();
		}
		return false;
		}
	
}
