import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class PhotoAlbum {

	public static void main(String[] args) throws Exception{
		//initializing which album
		int album;
		String url = "https://jsonplaceholder.typicode.com/photos?albumId=";
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the number of the album: ");
		album = scan.nextInt();
		scan.close();
		url = url + album;
		
			URL photos = new URL(url);
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(photos.openStream()));
	        //Read url data and pull ID's and Title's
	        String inputLine;
	        while ((inputLine = in.readLine()) != null)
	        {
	        	String ID = null;
	        	String Title = null;
	        	if(inputLine.contains("    \"id\":") )
	        	{
	              ID = getID(inputLine);
	        	}
	        	
	        	if(inputLine.contains("    \"title\":") )
	        	{
	        		Title = getTitle(inputLine);
	        	}
	        	
	             if(ID != null)
	             {
	        	    System.out.print(ID + " ");
	             }
	             if(Title != null)
	             {
	            	 System.out.print(Title);
	            	 System.out.println();
	             }
	           }
	        in.close();
		

	}
	
	public static String getID(String input) {
	    //Deleting all unneeded characters and adding braces.
		String toSend = null;
		if(input.contains("    \"id\":") )
	    {
	    	toSend = input.replace("    \"id\":", "");
	    	toSend = toSend.replace(",", "");
	    	toSend = toSend.trim();
	    	toSend = "[" + toSend + "]" + " ";
	    }
		
		return toSend;
	}
	
	public static String getTitle(String input) {
		//Deleting all unneeded characters.
	   String toSend = null;
		if(input.contains("    \"title\":") )
	    {
	    	toSend = input.replace("    \"title\":", "");
	    	toSend = toSend.replace(",", "");
	    	toSend = toSend.replace("\"", "");
	    	toSend = toSend.trim();
	    	
	    }
		
		return toSend;
	}

}
