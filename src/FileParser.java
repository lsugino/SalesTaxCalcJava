import java.io.*;
import java.util.ArrayList;

class FileParser {
	
	public File receiptToParse;
	
	public void /*ArrayList<String>*/ fileParser (File receipt) {
		receiptToParse = receipt;
		FileParser newFile = new FileParser();
		newFile.parseFile(receiptToParse);
	}
	
//	public void parserController (String args[]) {
//		FileParser newFile = new FileParser();
//		newFile.parseFile(receiptToParse);
//		System.out.println("does this hit?");
//	}
	
	public void /*ArrayList<String>*/ parseFile(File receiptToParse) {
      try {
    	  BufferedReader reader = new BufferedReader(new FileReader(receiptToParse));
    	  String strLine;
    	  
    	  while ((strLine = reader.readLine()) != null) {
    		System.out.println("Test input from file:");
    		System.out.println(strLine);
    		
            // Split each word and put it into a string array 
    		String[] info = strLine.split(" ");
    		
    		// arrayList to hold updated array
    		ArrayList<String> updArray = new ArrayList<String>();
    		updArray.add(info[0]);
    		
    		// build a string for the description + at    		
    		StringBuilder builder = new StringBuilder(info.length);

    		// grab the description and put into a string
            for (int i = 1; i < info.length - 1; i++)
                builder.append(info[i] + " ");
            
    		// grab the description and add to updated array
            updArray.add(builder.toString());

    		// add the last item in the original array and add to updated array
            updArray.add(info[info.length -1]);
            
    		// test value of updated array
	    	System.out.println("Each value in ArrayList:");
	        System.out.println(updArray.get(0));
	        System.out.println(updArray.get(1));
	        System.out.println(updArray.get(2));
            
//      	return updArray;
          
    	  }
    	  reader.close();

       	} catch (Exception e) {
        	System.err.println("Error: " + e.getMessage());
        }
   
    } // end of
}
