package PhotoAlbum;

import java.util.Scanner;

public class OutputFormat {
	
	public static void FormatOutput(String input)
	{
		
		if(input != "" && input != null)
		{
		
			
		Scanner scan = new Scanner(input);	
			
		while(scan.hasNextLine())
		{
		String inputLine = scan.nextLine();
		String ID = null;
    	String Title = null;
    	if(inputLine.contains("    \"id\":") )
    	{
          ID = OutputFormat.getID(inputLine);
    	}
    	
    	if(inputLine.contains("    \"title\":") )
    	{
    		Title = OutputFormat.getTitle(inputLine);
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
         
         scan.close();
		}
	}
	
	
	
	public static String getID(String input) {
	    //Deleting all unneeded characters and adding braces.
		String toSend = null;
		if(input != null && input.contains("    \"id\":") )
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
		if(input != null && input.contains("    \"title\":") )
	    {
	    	toSend = input.replace("    \"title\":", "");
	    	toSend = toSend.replace(",", "");
	    	toSend = toSend.replace("\"", "");
	    	toSend = toSend.trim();
	    	
	    }
		
		return toSend;
	}
}
