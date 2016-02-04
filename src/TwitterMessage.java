import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwitterMessage {
	private String tweetText;
	private ArrayList<String> words;
	private ArrayList<String> mentions;
	private ArrayList<String> links;
	private LocalDateTime dateTime;
	
	public TwitterMessage(String text){
		tweetText = text;
		mentions = new ArrayList<String>();
		String temp;
		words = new ArrayList<String>(Arrays.asList(text.split("[ ]+")));
		dateTime = LocalDateTime.now();
		for(int i = 0; i < words.size(); i++){
			if(words.get(i).charAt(0) == '@'){
				temp = words.get(i);
				mentions.add(temp);
				System.out.println(temp + " added to mentions");
			}
			System.out.println( i + " " + words.get(i));
			
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
	public ArrayList<String> getMentions(){
		return mentions;
	}
}
