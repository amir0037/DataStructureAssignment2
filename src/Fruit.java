/**
* Subclass of the FoodItem class. Overrides methods to add specific field to the FoodItem instance.
* Contains a constructor to instantiate an object of FoodItem or its child classes 
* @author  Maria Amirova (040980332)
* @date October 17, 2020
* @version 1.0 
* Assignment #2
*/
import java.util.Scanner;

public class Fruit extends FoodItem {

	private String orchardName;
	
	Fruit() {
		this(0, null, 0, 0, 0, null);}
	Fruit(int itemCode, String itemName, float itemPrice, int itemQuantityInStock, float itemCost, String orchardName){
		super(itemCode, itemName, itemPrice, itemQuantityInStock, itemCost);
		this.orchardName=orchardName;
	}
	/**
 	*inherit parent's toString method and add an extra field (orchardName) to be printed
 	*@return String of each object of Fruit class
	*/
	@Override
	public String toString() {
		return super.toString() + ", Orchard supplier: " + orchardName + "\n";
	}
	
	/**
 	*inherit parent's method and ask user to input an extra field which is related only to Fruit class
 	*@param scanner - instance of Scanner class
 	*@return true if input satisfy all the requirements, otherwise false 
	*/
	@Override
	public boolean addItem(Scanner scanner) {
		super.addItem(scanner);
		System.out.println("Enter the name of the orchard supplier");
		this.orchardName = scanner.next();
		return true;	}
}
