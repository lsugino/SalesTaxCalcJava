import java.io.*;
import java.math.BigDecimal;

public class FileParser {
	private File receipt;
	private int quant;
	private String desc;
	private BigDecimal price;
	private CartController cart;

	// Constructor
//    public FileParser (File textInput) {
//		receipt = textInput;
//		parserController(receipt);
//    }
    
    // FileParser Constructor
    public FileParser(File textInput, CartController myCart) {
    	receipt = textInput;
    	cart = myCart;
    	parserController(receipt);
    }

    public void parserController(File receipt) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(receipt));
            String strLine;
          
            while ((strLine = reader.readLine()) != null) {
                String[] splitArray = toStrArray(strLine);
                quant = getQuant(splitArray);
                desc = formatDesc(splitArray);
                price = getPrice(splitArray);
//              prodToString(quant, desc, price);                
                Product newProd = new Product(quant, desc, price);
                //FIXME add products to cart after product creation
                cart.addToCart(newProd);
            }
            reader.close();
            // Call to process cart
            cart.processCart();
            
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
     
     public int getQuant() {
    	 return quant;
     }
     
     public String getdesc() {
    	 return desc;
     }
     
     public BigDecimal getPrice() {
    	 return price;
     }
    
}
    		