import java.io.*;
import java.math.BigDecimal;

public class FileParser {
	private File receipt;
	private int quant;
	private String desc;
	private BigDecimal price;
	private Cart cart;

	public FileParser() {}
	
    /** FileParser Constructor */
    public FileParser(File textInput, Cart myCart) {
    	receipt = textInput;
    	cart = myCart;
    	parserController(receipt);
    }
    
    /** Takes input file, parses it, and adds to cart */
    public void parserController(File receipt) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(receipt));
            String strLine;
            while ((strLine = reader.readLine()) != null) {
                String[] splitArray = toStrArray(strLine);
                getQuant(splitArray);
                formatDesc(splitArray);
                getPrice(splitArray);
                Product newProd = new Product(quant, desc, price);
                cart.addToCart(newProd);
            }
            reader.close();
            Cart myCart = new Cart(cart);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
	}

    /** Split each word and put it into a string array */ 
	public String[] toStrArray(String strLine) {
		String[] splitArray = strLine.split(" ");
        return splitArray;
    }
    
	/** Get first value in array and assign to quantity */
    public int getQuant(String[] splitArray) {
      String strQuant = splitArray[0];
      quant = Integer.parseInt(strQuant);
      return quant;
    }

    /** Build a string description */    
    public String formatDesc(String[] splitArray) {
        StringBuilder builder = new StringBuilder(splitArray.length);
        for (int i = 1; i < splitArray.length - 2; i++){
             builder.append(splitArray[i] + " ");
        }
        desc = builder.toString().trim();
        return desc;
    }
                
    /** Add the last item in the original array and add to updated array */
     public BigDecimal getPrice(String[] splitArray) {
    	 String strPrice = (splitArray[splitArray.length -1]);
    	 price = toBigDec(strPrice);
    	 return price;
     }
     
     // Turn string into integer
     public int toInteger(String strNum) {
         return Integer.parseInt(strNum);
     }
     
     // Turn string into a big decimal
     public BigDecimal toBigDec(String strPrice) {
         BigDecimal bdPrice = new BigDecimal(strPrice);
         return bdPrice;
     }
     
}
    		