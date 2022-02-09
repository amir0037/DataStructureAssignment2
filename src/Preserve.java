/**
* Subclass of the FoodItem class. Overrides methods to add specific field to the FoodItem instance.
* Contains a constructor to instantiate an object of FoodItem or its child classes 
* @author  Maria Amirova (040980332)
* @date October 17, 2020
* @version 1.0 
* Assignment #2
*/
import java.util.Scanner;

public class Preserve extends FoodItem {

	private int jarSize;

	Preserve() {
		this(0, null, 0, 0, 0, 0);
	}

	Preserve(int itemCode, String itemName, float itemPrice, int itemQuantityInStock, float itemCost, int jarSize) {
		super(itemCode, itemName, itemPrice, itemQuantityInStock, itemCost);
		this.jarSize = jarSize;
	}
	/**
 	*inherit parent's toString method and add an extra field (jarSize) to be printed
 	*@return String of each object of Preserve class
	*/
	@Override
	public String toString() {
		return super.toString() + ", Size: " + jarSize + " ml\n";
	}

	/**
 	*inherit parent's method and ask user to input an extra field which is related only to Preserve class
 	*@param scanner - instance of Scanner class
 	*@return true if input satisfy all the requirements, otherwise false 
	*/
	@Override
	public boolean addItem(Scanner scanner) {
		super.addItem(scanner);
		System.out.println("Enter the size of the jar in millilitres: ");
		this.jarSize = scanner.nextInt();
		return true;
	}
}
