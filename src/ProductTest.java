import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;


public class ProductTest {
	Product testProd  = new Product();
	Product testProd2  = new Product();
	String testString = "box of coco";
	String testString2 = "bottles of imported beer";
	String testString3 = "bottles of headache pills";
	
	@Test
	public void testGetLocality() {
		testProd.getLocality(testString);
		testProd2.getLocality(testString2);
		assertEquals(true, testProd._isLocal);
		assertEquals(false, testProd2._isLocal);
	}
	
	@Test
	public void testGetTaxability() {
		ArrayList<String> _exemptProducts;
		File exemptList2 = new File("/Users/lsugino/Documents/workspace/SalesTaxJava/ExemptProducts");
		ExemptProductParser exemptToParse2 = new ExemptProductParser(exemptList2);
		_exemptProducts = exemptToParse2.getExemptArray();
		
		testProd.getTaxability(testString, _exemptProducts);
		testProd2.getTaxability(testString3, _exemptProducts);
		assertEquals(true, testProd._isTaxable);
		assertEquals(false, testProd2._isTaxable);
	}

}
