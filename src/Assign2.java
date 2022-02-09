/**
* Contains main method to call the display menu method
* @author  Maria Amirova (040980332)
* @date October 17, 2020
* @version 1.0 
* Assignment #2
*/
import java.util.LinkedList;
import java.util.Scanner;

public class Assign2 {

	
	public static void main(String[] args) {

		displayMenu();
	}

	/**
	*shows the menu so that user can choose one of the 6 options 
	*/
	public static void displayMenu() {
		Inventory inv = new Inventory();
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		while (choice != 6) {
			System.out.println("Please select one of the following:\r\n" + "1: Add Item to Inventory\r\n"
					+ "2: Display Current Inventory\r\n" + "3: Buy Item(s)\r\n" + "4: Sell Item(s)\r\n"
					+ "5: Convert ArrayList to Linkedlist and print it.\r\n" + "6: To Exit");

			choice = scanner.nextInt();
			switch (choice) {

			case 1:
				inv.addItem(scanner);
				break;

			case 2:
				System.out.println("Inventory:");
				inv.toString();
				break;

			case 3:
				if (inv.getInventory().isEmpty()) {
					System.out.println("Error...could not buy item, inventory is empty");
				} else inv.updateQuantity(scanner, true);					
				break;

			case 4:
				if (inv.getInventory().isEmpty()) {
					System.out.println("Error...could not sell item, inventory is empty");
				} else inv.updateQuantity(scanner, false);
				break;

			case 5:
		        LinkedList<FoodItem> linkedInventory = new LinkedList<>(); 
		 		for (FoodItem item : inv.getInventory()) { 
		  
		            linkedInventory.add(item); 
		        } 
		 		if (linkedInventory.isEmpty()) {
					System.out.println("Linked inventory is empty");}
		 		else
		        System.out.println("Inventory in the Linked List");
		        for (FoodItem item : linkedInventory)
					System.out.print(item);

				break;

			case 6:
					System.out.println("Exiting");
				break;

			}
		}
	}
}
