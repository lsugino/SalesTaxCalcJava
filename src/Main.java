import java.io.File;

public class Main {
	public static void main(String args[]) {
		/* Assuming input would be assigned on a one cart per printed receipt basis,
		 * change file according to input (input 1, input 2, or input 3)
		 */
		File receipt = new File("/Users/lsugino/Dropbox/Programming/SalesTax-Calculator/Input3.txt");
		
		Cart newCart = new Cart();
		FileParser textInput = new FileParser(receipt, newCart);
	}
}
