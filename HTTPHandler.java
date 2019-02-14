package PhotoAlbum;

import java.io.BufferedReader;
import java.io.IOException;

public class HTTPHandler {

	public static String HTTPHandle(BufferedReader in)
	{
	
	String Site = "";
	
	if(in != null)
	{
	try {
	String inputLine;
    while ((inputLine = in.readLine()) != null)
    {
    	Site = Site + "\n" + inputLine;
       }
    in.close();
	}catch(IOException e)
	{
		System.out.println("Page not available.");
		
	}
	
	}
    return Site;
	}
	
	
}
