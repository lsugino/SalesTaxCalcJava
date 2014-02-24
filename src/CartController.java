import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CartController {
	ArrayList<Product> _cart = new ArrayList<Product>();
	BigDecimal _totalTax = BigDecimal.ZERO;
	BigDecimal _receiptTotal = BigDecimal.ZERO;
	
	/** Takes in PRODUCT adds to the cart. */
	public void addToCart(Product merch) {
		_cart.add(merch);
	}
	
	/** When called, processes items in the cart. */
	public void processCart(){
		//FIXME
		//calculate tax from the price of each individual product in the cart and sets the tax only price
		for (Product prod : _cart) {
			int quantity = prod._qty;
			String description = prod._itemDesc;
			BigDecimal preTax = prod._preTaxPrice;
			boolean isLocal = prod._isLocal;
			boolean isTaxable = prod._isTaxable;
			
			ProductTaxCalculator calcItemTax = new ProductTaxCalculator(quantity,
					preTax, isLocal, isTaxable);
			BigDecimal taxOnly = calcItemTax.getItemTax();
			prod.setTax(taxOnly);
			System.out.println(prod._taxOnly);
		}	
		//find the total tax
		for (Product prod : _cart) {
			_totalTax = _totalTax.add(prod._taxOnly);		
		}
		System.out.println(_totalTax);
		//find product + tax price
		for (Product prod : _cart) {
			prod.setPostTaxPrice(prod._preTaxPrice, prod._taxOnly);
			System.out.println(prod._postTaxPrice);	
		}
//		System.out.println(prod._postTaxPrice);
		
		for (Product prod : _cart) {
			
		}
		
		//find the total price
		for (Product prod : _cart)  {
//			_receiptTotal = _receiptTotal.add(prod._preTaxPrice + prod._taxOnly)
		}
		//print receipt from above calculations
	}	
		
		/* get quantity, description and price from parser */
//		FileParser receiptFile = new FileParser(receipt);
//		receiptFile.parserController(receipt);
//		receiptFile.getQuant();
		
	
}
