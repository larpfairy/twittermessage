import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwitterMessage {
	private String tweetText;
	private String[] words;
	private String[] mentions;
	private String[] links;
	private LocalDateTime dateTime;
	
	public TwitterMessage(String text){
		tweetText = text;
		String temp;
		int count = 0;
		dateTime = LocalDateTime.now();
		this.words = text.split("[ ]+");
		for(int i = 0; i < words.length; i++){
			if(words[i].charAt(0) == '@'){
				temp = words[i];
				//mentions[count] = temp;
				//count++;
			}
			System.out.println(words[i]);
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
	public String[] getMentions(){
		return mentions;
	}
}
