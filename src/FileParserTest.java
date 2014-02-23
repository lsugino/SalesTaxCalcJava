import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;


public class FileParserTest {

	@Test
	public void main() {
		File testReceipt = new File("/Users/lsugino/Dropbox/Programming/SalesTax-Calculator/Input3.txt");
		FileParser testInput = new FileParser(testReceipt);
		testInput.parserController(testReceipt);
//		assertEquals("string to array", ["a", "box", "of", "coco"], testInput.toStrArray("a box of coco"));
	}

}
