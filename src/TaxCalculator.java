import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator {
	private BigDecimal itemTax;
	private BigDecimal totalPrice;
	private BigDecimal totalTax;
	private BigDecimal baseDomesticTax = new BigDecimal(0.10);
	private BigDecimal importTax = new BigDecimal(0.05);
	private BigDecimal nonExemptIntlTax = new BigDecimal(0.15);
	
	/* TaxCalculator constructor */
	public TaxCalculator(int _qty, BigDecimal _preTaxPrice, boolean _isLocal, boolean _isTaxable) {
		int taxCode = checkTaxAmt(_isLocal, _isTaxable);
		System.out.println(taxCode);
		calcTax(_qty, _preTaxPrice, taxCode);
		System.out.println(itemTax);
		
		//  round up itemTax to .05%	
//		salesTax = subTotal.multiply(taxRate);
//		salesTax = round(salesTax);
//		invoiceTotal = subTotal.add(salesTax);
		
		// return item tax, total price, total tax 		
	}
	
	/* Check what amount of tax needs to be added to pretax price */
	public int checkTaxAmt(boolean _isLocal, boolean _isTaxable) {
		int taxCode = 0;
		if (_isLocal == true) {
			if (_isTaxable) taxCode = 1; else taxCode = 2;
		} else {
			if (_isTaxable) taxCode = 3; else taxCode = 4;
		}
		return taxCode;
	}
	
	/* Check if taxable */
	public boolean checkExempt(boolean _isLocal, boolean _isTaxable) {
		if (_isTaxable == true) {
			System.out.println("is Taxable");
			return true;
		} else {
			System.out.println("is not Taxable");
			return false;
		}
	}
	
	/* Calculate tax for product */
	public BigDecimal calcTax(int _qty, BigDecimal _preTaxPrice, int taxCode) { 	
		BigDecimal tax = new BigDecimal(0.0);
		if (taxCode == 1) {
			tax = calcLocalTaxable(_qty, _preTaxPrice); 
		} else if (taxCode == 2) {
			tax = calcLocalExempt();
		} else if (taxCode == 3) {
			tax = calcTaxableImported(_qty, _preTaxPrice);
		} else if (taxCode == 4) {
			tax = calcLocalImpt(_qty, _preTaxPrice);
		}
		itemTax = round(tax);
		return itemTax;
	}
	
//	switch (taxCode) {
//	case 1:
//		tax = calcLocalTaxable(_qty, _preTaxPrice);
//		break;
//	case 2:
//		tax = calcLocalExempt();
//		break;
//}
//
//tax.setScale(2, RoundingMode.HALF_UP);
//
//return tax;
	
	/* Calculate tax for Local + Taxable product */
	public BigDecimal calcLocalTaxable(int _qty, BigDecimal _preTaxPrice) {
		BigDecimal taxAmt1 = calcTaxByQuant(_qty, _preTaxPrice);
		return taxAmt1.multiply(baseDomesticTax);
	}
	
	/* Calculate tax for Local + Exempt product */
	public BigDecimal calcLocalExempt() {
		BigDecimal taxAmt2 = new BigDecimal(0.00);
		return taxAmt2;
	}
	
	/* Calculate tax for Imported + Taxable product */
	public BigDecimal calcTaxableImported(int _qty, BigDecimal _preTaxPrice) {
		BigDecimal taxAmt3 = calcTaxByQuant(_qty, _preTaxPrice);
		return taxAmt3.multiply(nonExemptIntlTax);
	}
	
	/* Calculate tax for Exempt + Imported product */
	public BigDecimal calcLocalImpt(int _qty, BigDecimal _preTaxPrice) {
		BigDecimal taxAmt3 = calcTaxByQuant(_qty, _preTaxPrice);
		return taxAmt3.multiply(importTax);
	}
	
	/* Calculate tax by quantity */
	public BigDecimal calcTaxByQuant(int _qty, BigDecimal _preTaxPrice) {
		return _preTaxPrice.multiply(new BigDecimal(_qty));
	}
	
	/* Calculate round up tax to nearest .05% */
	static BigDecimal round(BigDecimal preTax) {
		BigDecimal finalTax =  new BigDecimal(Math.ceil(preTax.doubleValue() * 20) / 20);
		System.out.println("line1: " + finalTax);
		return finalTax.setScale(2, RoundingMode.HALF_UP);
	}
	
}