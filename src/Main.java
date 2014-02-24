import java.io.File;

public class Main {
	public static void main(String args[]) {
		File receipt = new File("/Users/lsugino/Dropbox/Programming/SalesTax-Calculator/Input3.txt");
		
		CartController newCart = new CartController();
	
		FileParser textInput = new FileParser(receipt, newCart);
	}
}
