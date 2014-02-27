import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CartController {
	ArrayList<Product> _cart = new ArrayList<Product>();
	BigDecimal _totalTax = BigDecimal.ZERO;
	BigDecimal _receiptTotal = BigDecimal.ZERO;
	
	/** Takes in PRODUCT adds to the cart. */
	public void addToCart(Product product) {
		_cart.add(product);
	}
	
	/** When called, processes items in the cart. */
	public void processCart(){
		// set tax amount of each item
		for (Product prod : _cart) {
			ProductTaxCalculator calcItemTax = new ProductTaxCalculator(prod._qty, 
					prod._preTaxPrice, prod._isLocal, prod._isTaxable);
			BigDecimal taxOnly = calcItemTax.getItemTax();
			System.out.println("item tax: " + taxOnly);
			prod.setTax(taxOnly);
		}	
		// calculate the total tax
		for (Product prod : _cart) {
			_totalTax = _totalTax.add(prod._taxOnly);		
		}
		// find product + tax price
		for (Product prod : _cart) {
			prod.setPostTaxPrice(prod._preTaxPrice, prod._taxOnly);
		}
		// find the total receipt price
		for (Product prod : _cart)  {
			_receiptTotal = _receiptTotal.add(prod._postTaxPrice);
		}
	}	
	
	// Print receipt
	public void printReceipt() {
		for (Product prod : _cart)  {
			System.out.println(prod._qty + " " + prod._itemDesc + ": " + prod._postTaxPrice);
		}
		System.out.println("Sales Taxes: " + _totalTax);
		System.out.println("Total: " + _receiptTotal);
	}
}
