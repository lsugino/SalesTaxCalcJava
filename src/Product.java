import java.awt.List;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {
	private int _qty;
	private String _itemDesc;
	private BigDecimal _preTaxPrice;
	private BigDecimal _postTaxPrice;
	private boolean _isLocal;
	private boolean _isTaxable;
	private ArrayList<String> _exemptProducts;
	
	/*	Product constructor	*/
	public Product(int qty, String desc, BigDecimal price) {
		_qty = qty;
		_itemDesc = desc;
		_preTaxPrice = price;
		getLocality(_itemDesc);
		getExemptProducts();
		getTaxability(_itemDesc, _exemptProducts);
		TaxCalculator newCalc = new TaxCalculator(qty, _preTaxPrice, _isLocal, _isTaxable);
		prodInfoToString(_qty, _itemDesc, _preTaxPrice);
	}
	
	public void getLocality(String _itemDesc) {
		if (_itemDesc.matches(".*\\bimported\\b.*")) _isLocal = false; else _isLocal = true; 
	}
//	
	public boolean getTaxability(String _itemDesc, ArrayList<String> _exemptProducts) {
		int taxable = 0;
		for (String word : _itemDesc.split("\\s+")){
			if (_exemptProducts.contains(word)) {
				taxable++;
			}
		}
		return isTaxable(taxable);
	}
	
	public boolean isTaxable(int taxable) {
		if (taxable == 1) {
			_isTaxable = false;
			return false;
		} else {
			_isTaxable = true;
			return true;
		}
	}
	
	public void getExemptProducts() {
		File exemptList = new File("/Users/lsugino/Documents/workspace/SalesTaxJava/ExemptProducts");
		ExemptProductParser exemptToParse = new ExemptProductParser(exemptList);
		_exemptProducts = exemptToParse.getExemptArray();
	}
	
    /* Print product info */
    public void prodInfoToString(int _qty, String _itemDesc, BigDecimal _preTaxPrice) {
    	System.out.println("Product = quant: " + _qty + " descrip: " + _itemDesc + "price: " + _preTaxPrice);
    }
//    
	
//	double totalPrice;
//	totalPrice = 0.00;
//	for (int i = 0; i < allProducts.size (); i += 1) {
//		//  The result of allProducts.get(i) is a Product		
//		totalPrice += ((Product) allProducts.get(i)).price;
//	}
}
