import java.lang.reflect.Array;
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
		words = new ArrayList<String>(Arrays.asList(text.split(" ")));
	}
	public TwitterMessage(){
		dateTime = LocalDateTime.now();
	}
	public LocalDateTime getDate(){
		return this.dateTime;
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
	
}
