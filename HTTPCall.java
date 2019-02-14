package PhotoAlbum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPCall {

	public static BufferedReader callHTTP(String url) { 
		BufferedReader in = null;
		if(url != null)
		{
			URL photos;
	
	try {
		photos = new URL(url);
		 in = new BufferedReader(new InputStreamReader(photos.openStream()));
		return in;
	} catch (MalformedURLException e) {
		System.out.println("URL is malformed");
		
	} catch (IOException e)
	{
		System.out.println("IOException on url stream opening, Page not available.");
		
	}
   
    
	}
		return in;
		
	}
	
	
	
}
