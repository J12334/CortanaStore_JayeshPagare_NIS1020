package com.cortanastore.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.item.model.Category;
import com.item.model.Item;

import static com.cortanastore.util.ItemUtil.addNewProduct;
import static com.cortanastore.util.ItemUtil.LoadItemlist;
import static com.cortanastore.util.ItemValidation.checkDuplicateProductCode;

public class CortanaStoreInteract_App {

	
public static void main(String[] args) {
		
try(Scanner scn = new Scanner(System.in);
	BufferedReader brRead = new BufferedReader(new InputStreamReader(System.in))) {
	
	// hard coded item list
	List<Item> productList = LoadItemlist();
	
	System.out.println("CARTANA STORE - Your one stop for everything");
	System.out.println("--------------------------------------------");
	System.out.println("Enter accordingly :-");
	
	
	boolean loop = true;
	
	while(true) {
		System.out.println("1 to Add new item");
		System.out.println("2 to List all available products by Category");
		System.out.println("3 to Search products by item code or item name");
		System.out.println("4 to list all the products");
		System.out.println("5 to End Session");
		System.out.println("Enter here : ");
		int choice = scn.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Enter the Item code: ");
			String ItemCode = brRead.readLine();
			checkDuplicateProductCode(ItemCode, productList);
			System.out.println("Enter Item name: ");
			String productName = brRead.readLine();
			System.out.println("Enter Buying Price: ");
			double buyingPrice = scn.nextDouble();
			System.out.println("Enter Selling Price: ");
			double sellingPrice = scn.nextDouble();
			System.out.println("Enter Item Category: ");
			String category = brRead.readLine().toUpperCase();
			System.out.println("Enter Tax Rate: ");
			double tax = scn.nextDouble();
			System.out.println("Enter Quantity: ");
			int quantity = scn.nextInt();
			
			addNewProduct(ItemCode, productName, buyingPrice, sellingPrice, category, tax, quantity);
			break;

		case 2:
			System.out.println("Enter category of item you are looking for from the following options: CAMERA, LAPTOP, WATCH, MOBILEPHONE");
			String searchCategory = brRead.readLine().toUpperCase();
			
			for (Item product : productList) {
				if(product.getCategory() == Category.valueOf(searchCategory)) {
					System.out.println(product);
				} 
			}
			break;
			
		case 3:
			System.out.println("Enter item name or item code to be searched search: ");
			String search = brRead.readLine().toUpperCase();
			
			for (Item product : productList) {
				if(product.getItemCode().equals(search) || product.getItemName().toUpperCase().equals(search)) {
					System.out.println("Task Completed");
					System.out.println("These are the item details: ");
					System.out.println(product);
				}
			}
			break;
			
		case 4:
			for (Item product : productList) {
				System.out.println(product);
			}
			break;
			
		case 10:
			loop = false;
			break;
			
		default:
			System.out.println("Not a valid choice");
			break;
		}
	}
} catch (Exception e) {
	System.err.println(e.getMessage());
}

		
	}
	
	
	
}


