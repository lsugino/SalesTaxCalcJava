import java.io.File;

public class Main {
	public static void main(String args[]) {
//		File exemptList = new File("/Users/lsugino/Documents/workspace/SalesTaxJava/ExemptProducts");
//		ExemptProductParser exemptProducts = new ExemptProductParser(exemptList);
		
		File receipt = new File("/Users/lsugino/Dropbox/Programming/SalesTax-Calculator/Input3.txt");
		FileParser textInput = new FileParser(receipt);
	}
}
