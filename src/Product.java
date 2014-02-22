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
	private float _postTaxPrice;
	private boolean _isLocal;
	private boolean _isTaxable;
	private ArrayList<String> _exemptProducts;
	
	/*	Instantiate a new product with quantity, description, and price	*/
	public Product(int qty, String desc, BigDecimal price) {
		_qty = qty;
		_itemDesc = desc;
		_preTaxPrice = price;
		getLocality(_itemDesc);
		System.out.println(_isLocal);
//		prodInfoToString(_qty, _itemDesc, _preTaxPrice);
	}
	
	public void getLocality(String _itemDesc) {
		_isLocal = _itemDesc.matches(".*\\bimported\\b.*");
	}
//	
//	public boolean getTaxable(String _itemDesc) {
//		
//	}
	
//	public ArrayList<String> getExemptProducts {
//		File receipt = new File("/Users/lsugino/Dropbox/Programming/SalesTax-Calculator/ExemptProducts.txt");
//		
//	}
	
    /* Print product info */
//    public void prodInfoToString(int _qty, String _itemDesc, BigDecimal _preTaxPrice) {
//    	System.out.println("to string Product");
////    	System.out.println("Product = quant: " + _qty + " description: " + _itemDesc + "price: " + _preTaxPrice);
//    }
//    
	
//	double totalPrice;
//	totalPrice = 0.00;
//	for (int i = 0; i < allProducts.size (); i += 1) {
//		//  The result of allProducts.get(i) is a Product		
//		totalPrice += ((Product) allProducts.get(i)).price;
//	}
}
