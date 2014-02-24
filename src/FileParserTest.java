import static org.junit.Assert.*;

import java.io.File;
import java.math.BigDecimal;

import org.junit.Test;


public class FileParserTest {
	FileParser testParser = new FileParser();
	String[] arrDesc = new String[]{"1", "box", "of", "coco", "at", "2.00"};
	String[] arrDesc2 = new String[]{"3", "bottles", "of", "imported", "beer", "at", "12.99"};
	
//	@Test
//	public void testFileParser() {
//		File testReceipt = new File("/Users/lsugino/Dropbox/Programming/SalesTax-Calculator/Input3.txt");
//		FileParser testInput = new FileParser(testReceipt);
//		testInput.parserController(testReceipt);
//	}
	
//	public void testParserController() {
//		File testReceipt = new File("/Users/lsugino/Dropbox/Programming/SalesTax-Calculator/Input3.txt");
//		FileParser testInput = new FileParser(testReceipt);
//		testInput.parserController(testReceipt);
//	}

	@Test
	public void testToStringArray() {
		String desc = "1 box of coco at 2.00";
		String desc2 = "3 bottles of imported beer at 12.99";
		String[] expected = new String[]{"1", "box", "of", "coco", "at", "2.00"};
		String[] expected2 = new String[]{"3", "bottles", "of", "imported", "beer", "at", "12.99"};
		assertArrayEquals(expected, testParser.toStrArray(desc));
		assertArrayEquals(expected2, testParser.toStrArray(desc2));
	}
	
	@Test
	public void testGetQuant() {
		assertEquals(1, testParser.getQuant(arrDesc));
		assertEquals(3, testParser.getQuant(arrDesc2));
	}
	
	@Test
	public void testFormatDesc() {
		String expected = "box of coco";
		String expected2 = "bottles of imported beer";
		assertEquals(expected, testParser.formatDesc(arrDesc));
		assertEquals(expected2, testParser.formatDesc(arrDesc2));
	}
	
	@Test
	public void testGetPrice() {
		BigDecimal expected = new BigDecimal("2.00");
		BigDecimal expected2 = new BigDecimal("12.99");
		assertEquals(expected, testParser.getPrice(arrDesc));
		assertEquals(expected2, testParser.getPrice(arrDesc2));
	}
	
	@Test
	public void testToInteger() {
		assertEquals(1, testParser.toInteger("1"));
		assertEquals(3, testParser.toInteger("3"));
	}
	
	@Test
	public void testToBigDec() {
		BigDecimal expected = new BigDecimal("2.00");
		BigDecimal expected2 = new BigDecimal("12.99");
		assertEquals(expected, testParser.toBigDec("2.00"));
		assertEquals(expected2, testParser.toBigDec("12.99"));
	}
}
