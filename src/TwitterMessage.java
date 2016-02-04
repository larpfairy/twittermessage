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
		tweetText = text;
		String temp;
		dateTime = LocalDateTime.now();
		this.words = Arrays.asList(text.split(" "));
		for(int i = 0; i < words.size(); i++){
			if(words.get(i).charAt(0) == '@'){
				temp = words.get(i);
				//mentions.add(temp);
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
}
