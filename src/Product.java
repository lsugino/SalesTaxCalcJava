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
	
	/*	Product constructor	*/
	public Product(int qty, String desc, BigDecimal price) {
		_qty = qty;
		_itemDesc = desc;
		_preTaxPrice = price;
		getLocality(_itemDesc);
		getExemptProducts();
		getTaxability(_itemDesc, _exemptProducts);
		ProductTaxCalculator newCalc = new ProductTaxCalculator(qty, _preTaxPrice, _isLocal, _isTaxable);
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
    	System.out.println("Product = qty: " + _qty + " desc: " + _itemDesc + "price: " + _preTaxPrice);
    }
    
    /* Set item tax  */
    public void setTax(BigDecimal tax) {
    	_taxOnly = tax;
    }
    
    /* set value of product + tax */
    public void setPostTaxPrice(BigDecimal price, BigDecimal tax) {
    	BigDecimal preTaxPrice = price;
    	_postTaxPrice = preTaxPrice.add(tax);
    }
    
}
