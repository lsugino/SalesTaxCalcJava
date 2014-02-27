import java.math.BigDecimal;
import java.util.ArrayList;

public class Cart {
	ArrayList<Product> _cart = new ArrayList<Product>();
	BigDecimal _totalTax = BigDecimal.ZERO;
	BigDecimal _receiptTotal = BigDecimal.ZERO;
	
	/** Constructs Cart */
	public Cart() {}
	
	/** Constructs Cart with an instance */
	public Cart(Cart newCart) {
		newCart.processCart();
    	newCart.printReceipt();
	}
	
	/** Takes in product and adds to the cart */
	public void addToCart(Product product) {
		_cart.add(product);
	}
	
	/** Processes items in the cart */
	public void processCart(){
		// set tax amount for each item
		for (Product item : _cart) {
			ProductTaxCalculator calcItemTax = new ProductTaxCalculator(item._qty, 
					item._preTaxPrice, item._isLocal, item._isTaxable);
			BigDecimal taxOnly = calcItemTax.getItemTax();
			item.setTax(taxOnly);
		}	
		// calculate the total tax
		for (Product item : _cart) {
			_totalTax = _totalTax.add(item._taxOnly);		
		}
		// calculate item price + tax
		for (Product item : _cart) {
			item.setPostTaxPrice(item._preTaxPrice, item._taxOnly);
		}
		// calculate total receipt price
		for (Product item : _cart)  {
			_receiptTotal = _receiptTotal.add(item._postTaxPrice);
		}
	}	
	
	/** Prints final receipt */
	public void printReceipt() {
		for (Product prod : _cart)  {
			System.out.println(prod._qty + " " + prod._itemDesc + ": " + prod._postTaxPrice);
		}
		System.out.println("Sales Taxes: " + _totalTax);
		System.out.println("Total: " + _receiptTotal);
	}
}
