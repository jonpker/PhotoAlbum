package PhotoAlbum;
import PhotoAlbum.OutputFormat;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import PhotoAlbum.HTTPCall;
import PhotoAlbum.HTTPHandler;
public class Tests {

	
	@Test
	public void getIDTests()
	{
		//if line contains an id then put it in brackets with a space.
		assertEquals("    \"id\": 23, must be [23] ", "[23] ",OutputFormat.getID("    \"id\":23,"));
		//if line does not contain the full id field then it will return null.
		assertEquals("    \"i 23, must be [23] ", null,OutputFormat.getID("    \"i23,"));
		//Checking to see that no NullPointerException occurs.
		assertEquals("null, must be null with no NullPointerException", null,OutputFormat.getID(null));
	}
	
	@Test
	public void getTitleTests()
	{
		//if line contains a title then it will be extracted with no other characters.
		assertEquals("    \"title\": Hello test must be Hello test","Hello test", OutputFormat.getTitle("    \"title\": Hello test"));
		//if line does not contain full title field, then it will return null.
		assertEquals("    \"title\": Hello test must be Hello test",null, OutputFormat.getTitle("    \"tit Hello test"));
		//Checking to see that no NullPointerException occurs.
		assertEquals("null must be null",null, OutputFormat.getTitle(null));
		
	}
	
	@Test
	public void FormatOutputTests()
	{
		//This input should output [52]  eveniet pariatur quia nobis reiciendis laboriosam ea
		// to the console.
		OutputFormat.FormatOutput("{\n" + 
				"    \"albumId\": 2,\n" + 
				"    \"id\": 52,\n" + 
				"    \"title\": \"eveniet pariatur quia nobis reiciendis laboriosam ea\",\n" + 
				"    \"url\": \"https://via.placeholder.com/600/121fa4\",\n" + 
				"    \"thumbnailUrl\": \"https://via.placeholder.com/150/121fa4\"\n" + 
				"  },");
		
		//This is to show that FormatOutput will not throw a NullPointerException.
		OutputFormat.FormatOutput(null);
		
	}
	
	@Test
	public void HTTPCallTests()
	{
		//When this is called when internet is not available, It should print IOException on url stream opening, Page not available.
		//This handles the exception thrown by BufferedReader.
		HTTPCall.callHTTP("https://jsonplaceholder.typicode.com/photos");
		//This is to test a malformed url. Instead of crashing, it will output URL is malformed in the console.
		HTTPCall.callHTTP("www.google.c");
		//This will show that a null URL will not throw a NullPointerException.
		HTTPCall.callHTTP(null);
	}
	
	@Test
	public void HTTPHandleTests()
	{
		//This will not work if the page is not available to begin with, but if connection is lost in the middle, 
		//This shows that it will output Page not available. rather than crashing the program.
		HTTPHandler.HTTPHandle(HTTPCall.callHTTP("https://jsonplaceholder.typicode.com/photos"));
		//This is to show that a null BufferedReader will not throw a NullPointerException.
		HTTPHandler.HTTPHandle(null);
	}
	
}
