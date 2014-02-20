import java.io.File;

public class Main {
	public static void main(String args[]) {
		File receipt = new File("/Users/lsugino/Dropbox/Programming/SalesTax-Calculator/Input1.txt");
		FileParser receiptInput = new FileParser();
		receiptInput.fileParser(receipt);
	}
}
