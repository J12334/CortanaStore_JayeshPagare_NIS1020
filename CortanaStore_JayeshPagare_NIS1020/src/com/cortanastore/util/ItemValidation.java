


package com.cortanastore.util;

import java.text.ParseException;
import java.util.List;

import com.cortanastore.exception.ItemException;
import com.item.model.Category;
import com.item.model.Item;

public class ItemValidation {

	// method to check for duplicate product code
	public static void checkDuplicateProductCode(String itemCode,
			List<Item> productList) throws ItemException {
		Item checkProduct = new Item(itemCode);
		for (Item product : productList) {
			if (product.equals(checkProduct)) {
				throw new ItemException("Duplicate product found!!!");
			}
		}
	}

	// method to validate buying price
	public static void validateBuyingPrice(double buyingPrice)
			throws ItemException {
		if (buyingPrice <= 0) {
			throw new ItemException(
					"Buying price has to be greater than 0!!!");
		}
	}
	
	// method to validate buying price
		public static void validateSellingPrice(double sellingPrice, double buyingPrice)
				throws ItemException {
			if (sellingPrice < buyingPrice) {
				throw new ItemException(
						"Selling price can't be less than buying price!!!");
			}
		}
		
		// method to validate product category
		public static Category validateCategory(String category) throws ParseException {
			Category checkCategory = Category.valueOf(category);
			return checkCategory;
		}
		
}
