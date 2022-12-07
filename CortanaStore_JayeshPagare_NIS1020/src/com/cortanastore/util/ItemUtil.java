//package com.cortanastore.util;
//
//public class ItemUtil {
//
//}








package com.cortanastore.util;

import static com.cortanastore.util.ItemValidation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.cortanastore.exception.ItemException;
import com.item.model.Category;
import com.item.model.Item;

public class ItemUtil {

	
	
	// Method to add new item
	public static Item addNewProduct(String itemCode, String itemName,
			double buyingPrice, double sellingPrice, String category,
			double tax, int quantity) throws ItemException, ParseException {
		
		validateBuyingPrice(buyingPrice);
		validateSellingPrice(sellingPrice, buyingPrice);
		Category checkCategory = validateCategory(category);
		
		return new Item(itemCode, itemName, buyingPrice, sellingPrice, checkCategory, tax, quantity);
	}

	// method to send a pre-loaded list
	public static List<Item> LoadItemlist() throws ParseException {
		List<Item> ItemList = new ArrayList<>();
		
		ItemList.add(new Item("1", "Gopro", 37000, 65000, Category.CAMERA, 30, 25));
		ItemList.add(new Item("2", "Canon", 55000, 70000, Category.CAMERA, 30, 20));
		ItemList.add(new Item("3", "HP", 100000, 135000, Category.LAPTOP, 30, 5));
		ItemList.add(new Item("4", "Lenovo", 70000, 85000, Category.LAPTOP, 30, 15));
		ItemList.add(new Item("5", "Fastrack", 800, 1800, Category.WATCH, 30, 50));
		
		
		return ItemList;
	}
	
}
