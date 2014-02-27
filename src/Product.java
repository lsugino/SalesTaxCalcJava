import java.awt.List;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {
	int _qty;
	String _itemDesc;
	BigDecimal _preTaxPrice;
	BigDecimal _postTaxPrice;
	BigDecimal _taxOnly;
	boolean _isLocal;
	boolean _isTaxable;
	ArrayList<String> _exemptProducts;
	
	public Product() {}
	
	/**	Product constructor	*/
	public Product(int qty, String desc, BigDecimal price) {
		_qty = qty;
		_itemDesc = desc;
		_preTaxPrice = price;
		getLocality(_itemDesc);
		getExemptProducts();
		getTaxability(_itemDesc, _exemptProducts);
		ProductTaxCalculator newCalc = new ProductTaxCalculator(qty, _preTaxPrice, _isLocal, _isTaxable);
	}
	
	/** Check if item is domestic or imported */
	public void getLocality(String _itemDesc) {
		if (_itemDesc.matches(".*\\bimported\\b.*")) _isLocal = false; else _isLocal = true; 
	}

	/** Check if item is taxable or exempt */
	public boolean getTaxability(String _itemDesc, ArrayList<String> _exemptProducts) {
		int taxable = 0;
		for (String word : _itemDesc.split("\\s+")){
			if (_exemptProducts.contains(word)) {
				taxable++;
			}
		}
		return getIsTaxable(taxable);
	}
	
	public boolean getIsTaxable(int taxable) {
		if (taxable == 1) {
			_isTaxable = false;
			return false;
		} else {
			_isTaxable = true;
			return true;
		}
	}
	
	/** Grab exempt list txt file and set to _exemptProducts */
	public void getExemptProducts() {
		File exemptList = new File("/Users/lsugino/Documents/workspace/SalesTaxJava/ExemptProducts");
		ExemptProductParser exemptToParse = new ExemptProductParser(exemptList);
		_exemptProducts = exemptToParse.getExemptArray();
	}
    
    // Set item tax
    public void setTax(BigDecimal tax) {
    	_taxOnly = tax;
    }
    
    // set value of product + tax
    public void setPostTaxPrice(BigDecimal price, BigDecimal tax) {
    	BigDecimal preTaxPrice = price;
    	_postTaxPrice = preTaxPrice.add(tax);
    }
    
}
