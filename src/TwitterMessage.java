import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwitterMessage {//This object will hold all of the relevant Tweet information.
	private String tweetText;//the actual word for word text of the tweet.
	private ArrayList<String> words;//All of the words in the tweet, separeted out into indexes of an ArrayList of strings
	private ArrayList<String> mentions;//Any mentions that are detected are put into an Arraylist called mentions.
	private ArrayList<String> links;//Any valid URL's that are contained in the tweetText will be put into this Arraylist
	private LocalDateTime dateTime;//The date of the tweet is recorded and stored in this variable.
	
	public TwitterMessage(String text){//Constructor which takes a twitter message in the form of a string and parses it into the relevant 
		tweetText = text;
		mentions = new ArrayList<String>();
		links = new ArrayList<String>();
		String temp;
		words = new ArrayList<String>(Arrays.asList(text.split("[ ]+")));
		dateTime = LocalDateTime.now();
		for(int i = 0; i < words.size(); i++){
			if(words.get(i).charAt(0) == '@'){
				temp = words.get(i);
				mentions.add(temp);
				//System.out.println(temp + " added to mentions");
			}
			System.out.println( i + " " + words.get(i));//prints out the string that is being url tested
			if(pingUrl(words.get(i))){
				links.add(words.get(i));
			}
		}
	}
	public TwitterMessage(){//constructor without a string argument, only sets the creation date
		dateTime = LocalDateTime.now();
	}
	public String getDate(){//returns a date in string format
		return this.dateTime.toString();
	}
	public void setDate(){//sets the date to the current time
		this.dateTime = LocalDateTime.now();
	}
	public String getTweetText(){//returns the string that contains the text of the tweet
		return tweetText;
	}
	public void setTweetText(String text){//changes the text of the tweet to the provided string arg
		this.tweetText = text;
	}
	public ArrayList<String> getWords(){//returns the array of all words found in the tweetText
		return words;
	}
	public void setWords(String word){
		if(words == null){
			words = new ArrayList<String>();
		}
		words.add(word);
	}
	public ArrayList<String> getMentions(){//returns ArrayList of all valid mentions in the tweetText
		return mentions;
	}
	public void addMentions(String mention){
		if(mentions == null){
			mentions = new ArrayList<String>();
		}
		mentions.add(mention);
	}
	public void setMentionsFromWords(){
		String temp;
		if(mentions == null){
			mentions = new ArrayList<String>();
		}
		if(words != null){
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).charAt(0) == '@'){
					temp = words.get(i);
					mentions.add(temp);
				}
		else{
			System.out.println("Words is not set");
			}
			}
		}
	}
	public boolean pingUrl(String Url){ //Found this code at http://stackoverflow.com/questions/10551813/check-if-url-is-valid-or-exists-in-java
										//It checks to see if a URL is valid.
		 HttpURLConnection connection = null;
		 try{         
		     URL myurl = new URL(Url);        
		     connection = (HttpURLConnection) myurl.openConnection(); 
		     //Set request to header to reduce load as Subirkumarsao said.       
		     connection.setRequestMethod("HEAD");         
		     int code = connection.getResponseCode();        
		     System.out.println("" + code); 
		 } catch (Exception ex){
			 System.out.println("Invalid URL");
			 return false;
		 //Handle invalid URL
		 }
		 return true;
	}
	public ArrayList<String> getLinks(){
		return links;
	}
	public void addLink(String link){
		if(pingUrl(link)){
			links.add(link);
		}
		
	}
}
