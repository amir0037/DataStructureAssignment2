/**
* FoodItem is the parent class for the Fruit, Vegetable, Preserve classes. 
* Contains a constructor to instantiate an object of FoodItem or its child classes 
* @author  Maria Amirova (040980332)
* @date October 17, 2020
* @version 1.0 
* Assignment #2
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class FoodItem {
	private int itemCode;
	private String itemName;
	private float itemPrice;
	private int itemQuantityInStock;
	private float itemCost;

	public int getItemQuantityInStock() {
		return itemQuantityInStock;
	}

	public void setItemQuantityInStock(int itemQuantityInStock) {
		this.itemQuantityInStock = itemQuantityInStock;
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}


	FoodItem() {
		this(0, null, 0, 0, 0);
	}

	FoodItem(int itemCode, String itemName, float itemPrice, int itemQuantityInStock, float itemCost) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantityInStock = itemQuantityInStock;
		this.itemCost = itemCost;
	}

	/**
 	*return a String of a specific format consisting of all object's fields.
 	*@return String of each object of FoodItem
	*/
	public String toString() {
		return "Item: " + itemCode + " " + itemName + ", Quantity: " + itemQuantityInStock + ", Price: " + itemPrice
				+ ", Cost: " + itemCost;
	}
	
//	public boolean updateItem(int amount) {
//		return true;
//	}

	/**
 	*add a new FoodItem to the inventory ArrayList
 	*<p>asks user to input item code (validate it), item name, 
 	*item quantity (validate it), item cost (validate it), item price (validate it), 
 	*if everything is valid, the item is added to the inventory
 	*@param scanner - instance of Scanner class
 	*@return true if input satisfy all the requirements, otherwise false 
	*/
	public boolean addItem(Scanner scanner) {
		inputCode(scanner);//code entering
		
		System.out.println("Enter name for the item");//name entering(no validation needed)
		this.itemName = scanner.next();
		
		boolean valid = false;//quantity validation
		while (valid == false) {
			try{System.out.println("Enter the quantity for the item");
			itemQuantityInStock = scanner.nextInt();
			if (itemQuantityInStock > 0) {
				valid = true;
			} else
				{valid = false;
			System.out.println("Error");}
			} catch(InputMismatchException ex) {System.out.println("Error, please enter a number");
			scanner.next();}}
		
		valid = false;//cost validation
		while (valid == false) {
			try{System.out.println("Enter the cost of the item");
			itemCost = scanner.nextFloat();
			if (itemCost > 0) {
				valid = true;
			} else
				{valid = false;
			System.out.println("Error");}
			} catch(InputMismatchException ex) {System.out.println("Error, please enter a number");scanner.next();}}
		
		valid = false;//price validation
		while (valid == false) {
			try{System.out.println("Enter the price of the item");
			itemPrice = scanner.nextFloat();
			if (itemPrice > 0) {
				valid = true;
			} else
				{valid = false;
			System.out.println("Error");}
			} catch(InputMismatchException ex) {System.out.println("Error, please enter a number");scanner.next();}}
		return true;
	}
	/**
 	*ask user to enter a code and validates it
 	*@param scanner - instance of Scanner class
 	*@return true if input satisfy all the requirements, otherwise false 
	*/
	public boolean inputCode(Scanner scanner) {//check if the input code is valid
		
		boolean valid = false;//code validation
		while (valid == false) {
			try{System.out.println("Enter the code for the item");
			itemCode = scanner.nextInt();
			if (itemCode > 0) {
				valid = true;
			} else
				{valid = false;
			System.out.println("Error");}
			} catch(InputMismatchException ex) {System.out.println("Error, please enter a number");scanner.next();}}

			return true;
	}
	
	/**
	*checks if the item codes are equal
 	*@param item of type FoodItem, take an object of FoodItem as a parameter
 	*@return true if input item codes match, otherwise false 
	*/
	public boolean isEqual(FoodItem item) { //Method returns true if the itemCodes are equal
		
		return this.itemCode == item.itemCode;

	}
}
