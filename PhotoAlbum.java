package PhotoAlbum;

import java.io.BufferedReader;
import PhotoAlbum.OutputFormat;
import PhotoAlbum.HTTPCall;
import PhotoAlbum.HTTPHandler;
import java.util.Scanner;

public class PhotoAlbum {

	public static void main(String[] args) {
		//Initializing which album to print.
		int album;
		String url = "https://jsonplaceholder.typicode.com/photos?albumId=";
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the number of the album: ");
		album = scan.nextInt();
		scan.close();
		url = url + album;
		//Open a connection.
		BufferedReader in = HTTPCall.callHTTP(url);
		//Read from connection into a string.
		String site = HTTPHandler.HTTPHandle(in);
		//Process and format string and print results.
		OutputFormat.FormatOutput(site);
		
	        
	        
		

	}
	
	

}
