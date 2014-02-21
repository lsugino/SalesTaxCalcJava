import java.io.*;
import java.util.ArrayList;

class FileParser {
	
	private File receiptToParse;
    private FileParser newFile;

	public void FileParser (File receipt) {
		receiptToParse = receipt;
		FileParser newFile = new FileParser();
		newFile.parserController(receiptToParse);
        System.out.println("test");
	}

    public void parserController(File receiptToParse) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(receiptToParse));
            String strLine;
            ArrayList<String> updArray;
          
            while ((strLine = reader.readLine()) != null) {
                System.out.println("Test input from file:");
                System.out.println(strLine);

                String[] splitArray = toStrArray(strLine);
                System.out.println(splitArray[0]);

                updArray = addQty(splitArray);
                System.out.println(updArray.get(0));

                String desc = formatDesc(splitArray);
                System.out.println(desc);

                // ArrayList<String> newArr = addDesc(desc);
                // System.out.println(newArr.get(0));
                // System.out.println(newArr.get(1));

                // newFile.addDesc(splitArray);
                // newFile.addPrice(splitArray);
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
	}

    // Split each word and put it into a string array 
	public String[] toStrArray(String strLine) {
		String[] splitArray = strLine.split(" ");
        System.out.println("testing");   
        return splitArray;
    }

    // arrayList to hold updated array
    public ArrayList<String> addQty(String[] splitArray) {
        ArrayList<String> updArray = new ArrayList<String>();
        updArray.add(splitArray[0]);
        return updArray;
    }

    // build a string for the description      
    public String formatDesc(String[] splitArray) {
        StringBuilder builder = new StringBuilder(splitArray.length);

        // grab the description and put into a string
        for (int i = 1; i < splitArray.length - 1; i++){
             builder.append(splitArray[i] + " ");
        }
        String desc = builder.toString();
        System.out.println(desc);
        return desc;
    }

    // grab the description and add to updated array
    // DOESN'T WORK
    // public ArrayList<String> addDesc(String desc) {
    //     updArray.add(desc);
    //     return updArray;
    // }
                
    // add the last item in the original array and add to updated array
    // public void addPrice(String desc) {
        // updArray.add(splitArray[splitArray.length -1]);
    // }
            
}
    		