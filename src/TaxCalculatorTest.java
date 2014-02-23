import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;


public class TaxCalculatorTest {

//	@Test
//	public void main() {
//		TaxCalculator testCalc = new TaxCalculator(1, 2.99, true, true);
//	}
	
	@Test
	public void testCheckTaxAmt() {
		int _qty = 1;
		BigDecimal _preTaxPrice = new BigDecimal(2.99);
		boolean _isLocal = true;
		boolean _isTaxable = true;
		
		TaxCalculator testCalc = new TaxCalculator(int _qty, BigDecimal _preTaxPrice, boolean _isLocal, boolean _isTaxable);		
		
		assertEquals(1, testCalc.checkTaxAmt(true, true));
	    assertEquals(2, testCalc.checkTaxAmt(true, false));
	    assertEquals(3, testCalc.checkTaxAmt(false, true));
	    assertEquals(4, testCalc.checkTaxAmt(false, false));
	}

}
