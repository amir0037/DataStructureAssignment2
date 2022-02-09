/**
* Contains the inventory (array list of food item objects). Contains all methods to operate the data 
* related to the array 
* @author  Maria Amirova (040980332)
* @date October 17, 2020
* @version 1.0 
* Assignment #2
*/
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inventory {

	private ArrayList<FoodItem> inventory = new ArrayList<>();
	private int numItems;
	Scanner scanner = new Scanner(System.in);
	FoodItem fi = null;

	public Inventory() {
	}

	/**
 	*iterating through the arraylist and returns a String of a specific format consisting of all object's fields.
 	*@return String of each object of FoodItem
	*/
	public String toString() {
		for (int i = 0; i < inventory.size(); i++) {
			System.out.print(inventory.get(i));
		}
		return "";
	}

	/**
 	*return a String of a specific format consisting of all object's fields.
 	*@param takes an object of FoodItem class
 	*@return the index of the object, otherwise -1
	*/
	public int alreadyExists(FoodItem item) {
		int x = 0;
		for (int i=0; i<inventory.size();i++) {
			if (inventory.get(i) == item)
				x = i;
			else
				x = -1;
		}
		return x;
	}

	/**

 	*asks user to input what kind of food he wants to add
 	**<p>create an object of the class according to the user's choice
 	*@param scanner - instance of Scanner class
 	*@return true if users make a choice within the available options, otherwise false
	*/
	public boolean addItem(Scanner scanner) {
		boolean stop = false;
		while (stop == false) {
			System.out.println("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
			char choice = scanner.next().charAt(0);
			if (choice == 'v') {
				fi = new Vegetable();
				fi.addItem(scanner);
				inventory.add(fi);
				stop = true;
			} else if (choice == 'f') {
				fi = new Fruit();
				fi.addItem(scanner);
				inventory.add(fi);
				stop = true;
			} else if (choice == 'p') {
				fi = new Preserve();
				fi.addItem(scanner);
				inventory.add(fi);
				stop = true;
			} else if (choice != 'v' && choice != 'f' && choice != 'p') {
				System.out.println("Invalid entry");
				stop = false;
			}
		}

		return true;
	}
	
	/**
 	*asks user to input the code for the item for which to change the quantity
 	*<p>
 	*if users wants to buy, the new amount is added to the old amount
 	*if users wants to sell, the new amount is subtracted from the old amount
 	*@param scanner - instance of Scanner class
 	*@param buyOrSell, boolean type to define if to buy or sell the item
 	*@return true if input satisfy all the requirements, otherwise false 
	*/
	public boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
		int itemQuantity=0;
		int itemCode=0;
			System.out.println("Enter the item code");
			itemCode = scanner.nextInt();
			boolean valid = false;//quantity validation
		while (valid == false) {
			try{System.out.println("Enter the quantity for the item");
			itemQuantity = scanner.nextInt();
			if (itemQuantity > 0) {
				valid = true;
			} else
				{valid = false;
			System.out.println("Error");}
			} catch(InputMismatchException ex) {System.out.println("Error, please enter a number");
			scanner.next();}}
		if (buyOrSell == true) {
			for (FoodItem item : getInventory()) {
				if (itemCode == item.getItemCode()) {
					int newAmount=item.getItemQuantityInStock()+itemQuantity;
					item.setItemQuantityInStock(newAmount);

				}
			}
				}
		else if (buyOrSell == false) {
			for (FoodItem item : getInventory()) {
				if (itemCode == item.getItemCode()) {
					int newAmount=item.getItemQuantityInStock()-itemQuantity;
					if(newAmount<0) {System.out.println("Error...could not sell item");}
					else
					item.setItemQuantityInStock(newAmount);

				}
			}
		}
		return true;
	}

	public ArrayList<FoodItem> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<FoodItem> inventory) {
		this.inventory = inventory;
	}

}
