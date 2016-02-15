import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

/*
 * The TwitterMessage class is intended to hold all of the tweet data and
 * contains all of the relevant functionality.
 * 
 * All mentions, links, words, and hashtags are parsed upon the instantiation of the tweet object
 * and placed into the corresponding ArrayList.
 * 
 * 
 */


public class TwitterMessage {
	
	//the actual word for word text of the tweet.
	private String tweetText;
	
	Utilities myUtility = new Utilities();
	
	//All of the words in the tweet, separated out into indexes of an ArrayList of strings
	private ArrayList<String> words;
	
	//All of the hashtags found in the tweetText get put into hashtags
	private ArrayList<String> hashtags;
	
	//Any mentions that are detected are put into an Arraylist called mentions.
	private ArrayList<String> mentions;
	
	//Any valid URL's that are contained in the tweetText will be put into this Arraylist
	private ArrayList<String> links;
	
	//The date of the tweet is recorded and stored in this variable
	private LocalDateTime dateTime;
	
	//Constructor which takes a twitter message in the form of a string and parses
	//the words into the relevant ArrayLists upon instantiation.
	public TwitterMessage(String text){
		
		//records text of the tweet
		tweetText = text;
		
		//initializes all ArrayLists and parses tweetText into words
		mentions = new ArrayList<String>();
		links = new ArrayList<String>();
		words = new ArrayList<String>(Arrays.asList(text.split("[ ]+")));
		hashtags = new ArrayList<String>();
		
		//sets the date
		this.setDate();
		
		//populates mentions, links, and hashtags
		//TODO use regular expressions
		for(int i = 0; i < words.size(); i++){
			
			//add mentions
			if(words.get(i).matches("[@@]+([A-Za-z]+)")){
				mentions.add(words.get(i));
			}
			
			//add hashtags
			if(words.get(i).matches("[##]+([A-Za-z0-9-_]+)")){
				hashtags.add(words.get(i));
			}
			
			//add urls, prints out the string that is being url tested
			System.out.println( i + " " + words.get(i));
			if(myUtility.pingUrl(words.get(i))){
				links.add(words.get(i));
			}
		}
	}
	
	//returns a date in string format
	public String getDate(){
		return this.dateTime.toString();
	}
	
	//sets the date to the current time
	public void setDate(){
		this.dateTime = LocalDateTime.now();
	}
	
	//returns the string that contains the text of the tweet
	public String getTweetText(){
		return tweetText;
	}
	
	//returns the array of all words found in the tweetText
	public ArrayList<String> getWords(){
		return words;
	}
	
	//returns ArrayList of all hashtags in the tweet
	public ArrayList<String> getHashTags(){
		return hashtags;
	}
	
	//returns ArrayList of all valid mentions in the tweetText
	public ArrayList<String> getMentions(){
		return mentions;
	}
	
	//returns an ArrayList of Links
	public ArrayList<String> getLinks(){
		return links;
	}
	
	//Adds a string to links if it is valid
	public void addLink(String link){
		if(myUtility.pingUrl(link)){
			links.add(link);
		}
		
	}
}
