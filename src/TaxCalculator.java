import java.io.*;

public class TaxCalculator {
//	private BigDecimal itemTax = 0.00;
//	private BigDecimal totalPrice = 0.00;
//	private BigDecimal totalTax = 0.00;
//	private BigDecimal baseDomesticTax = 0.10;
//	private BigDecimal importTax = 0.05;
//	private BigDecimal nonExemptInternationalTax = 0.15;
//	private BigDecimal rounding = (1/0.05);
//	
	
	
	public TaxCalculator (String qty, String desc, String price) {
		//loop through each line of ArrList 
			//	If exempt + origin == true	: * import tax	
			//  If exempt + origin == true & false : itemTax = 0.00
			//	If exempt + origin == false & true : * nonExemptInternationalTax
			//	If exempt + origin == false & false : * baseDomesticTax
		
		//  round up itemTax to .05%	
		
		//  add all the taxes together : total = itemtax * qty
		//  add all the prices together : total = itemprice * qty
		//  add all the taxes together : total = itemtax * qty
		
	}
	
}
