package main.java.Inventory;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> myInventory = new ArrayList<Item>();
	
	public ArrayList<Item> getInventory() {
		return myInventory;
	}
	
	/**
	 * Increases the quantity of the item sent in by 1.
	 * If the item is not in the inventory, it is added to the inventory.
	 * The inventory is sorted alphabetically.
	 * @param myItem The item to add to the inventory.
	 * @return The original item.
	 */
	public Item addToInventory(Item myItem) {
		if (myItem.getQuantity() > 0) {
			myItem.setQuantity(myItem.getQuantity() + 1);
		} else {
			int index = 0;
			while (myItem.getName().compareToIgnoreCase(myInventory.get(index).getName()) > 0) { // While the new item's name comes before the current index's item's name.
				index++;
			}
			myInventory.add(index, myItem);
		}
		
		return myItem;
	}
	
	/**
	 * Decreases the quantity of the item sent in by 1.
	 * If there is only 1 item, it is removed from the inventory.
	 * @param myItem The item to remove from the ArrayList
	 * @return The original item.
	 */
	public Item removeFromInventory(Item myItem) {
		if (myItem.getQuantity() > 1) { // If there is 1 or less of this item in the inventory
			myItem.setQuantity(myItem.getQuantity() - 1); // Decrease the quantity by 1.
		} else {
			myInventory.remove(myItem); // Remove the item
		}
		
		return myItem;
	}
}
