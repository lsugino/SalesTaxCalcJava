import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;


public class ProductTaxCalculatorTest {
	ProductTaxCalculator testCalc = new ProductTaxCalculator();
	
	@Test
	public void testCalcTax() {
		int _qty = 1;
		BigDecimal _preTaxPrice = new BigDecimal("27.99");
		int taxCode = 3;
		BigDecimal expected = new BigDecimal("4.20");
		assertEquals(expected, testCalc.calcTax(_qty, _preTaxPrice, taxCode));
	}
}
