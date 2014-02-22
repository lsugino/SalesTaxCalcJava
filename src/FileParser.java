import java.io.*;
import java.math.BigDecimal;

public class FileParser {
    
	// Constructor
    public FileParser (File txtInput) {
		parserController(txtInput);
    }

    public void parserController(File textInput) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(textInput));
            String strLine;
          
            while ((strLine = reader.readLine()) != null) {
            	
            	/* Convert string to array of strings */
                String[] splitArray = toStrArray(strLine);

                /* Set first value in array to quantity */
                int quant = getQuant(splitArray);
                
                /* Convert description values into a string */
                String desc = formatDesc(splitArray);

                /* Set last value to price */
                BigDecimal price = getPrice(splitArray);
                
                /* Print out the Product */
                prodToString(quant, desc, price);
                
                Product newProd = new Product(quant, desc, price);
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
	}

    // Split each word and put it into a string array 
	public String[] toStrArray(String strLine) {
		String[] splitArray = strLine.split(" ");
        return splitArray;
    }
    
    public int getQuant(String[] splitArray) {
      String strQuant = splitArray[0];
      int intQuant = Integer.parseInt(strQuant);
      return intQuant;
    }

    // build a string for the description      
    public String formatDesc(String[] splitArray) {
        StringBuilder builder = new StringBuilder(splitArray.length);

        // grab the description and put into a string
        for (int i = 1; i < splitArray.length - 2; i++){
             builder.append(splitArray[i] + " ");
        }
        String desc = builder.toString();
        return desc;
    }
                
    // add the last item in the original array and add to updated array
     public BigDecimal getPrice(String[] splitArray) {
    	 String strPrice = (splitArray[splitArray.length -1]);
    	 BigDecimal intPrice = toBigDec(strPrice);
    	 return intPrice;
     }
     
     // add the last item in the original array and add to updated array
     public void prodToString(int quant, String desc, BigDecimal price) {
    	 System.out.println("Parser product = quant: " + quant + " description: " + desc + "price: " + price);
     }
     
     // turn string into integer
     public int toInteger(String strNum) {
         return Integer.parseInt(strNum);
     }
     
     // turn string into a big decimal
     public BigDecimal toBigDec(String strPrice) {
         BigDecimal bdPrice = new BigDecimal(strPrice);
         return bdPrice;
     }
    
}
    		