import java.net.HttpURLConnection;
import java.net.URL;

public class Utilities {
	public boolean pingUrl(String Url){ //Found this code at http://stackoverflow.com/questions/10551813/check-if-url-is-valid-or-exists-in-java
		//It checks to see if a URL is valid.
	HttpURLConnection connection = null;
	try{         
		URL myurl = new URL(Url);        
		connection = (HttpURLConnection) myurl.openConnection(); 
		connection.setRequestMethod("HEAD");         
		int code = connection.getResponseCode();        
		System.out.println("" + code);
	}
	catch (Exception ex){
	System.out.println("Invalid URL");
	return false;
	//Handle invalid URL
	}
	return true;
	}
}
