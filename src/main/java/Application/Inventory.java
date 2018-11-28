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
		if (myInventory.isEmpty()) {
			myInventory.add(myItem);
			return myItem;
		}
		
		int index = 0;
		while (index < myInventory.size() && myItem.getName().compareToIgnoreCase(myInventory.get(index).getName()) >= 0) { // While the new item's name comes before the current index's item's name, or the new item is already in the inventory.
			if (myItem.getName().equalsIgnoreCase(myInventory.get(index).getName())) { // If the item is already in the inventory, combine the quantities.
				myInventory.get(index).setQuantity(myInventory.get(index).getQuantity() + myItem.getQuantity());
				myItem.setQuantity(myInventory.get(index).getQuantity());
				return myItem;
			}
			index++;
		}
		myInventory.add(index, myItem);
		
		return myItem;
	}
	
	/**
	 * Removes the quantity of the item given from the inventory.
	 * If the item then has 0 quantity, it is removed from the list.
	 * @param myItem The item to remove from the ArrayList
	 * @return The original item, or null if the item wasn't in the inventory to begin with.
	 */
	public Item removeFromInventory(Item myItem) {
		int index = 0;
		while (index < myInventory.size()) {
			if (myInventory.get(index).getName().equals(myItem.getName())) {
				myInventory.get(index).setQuantity(myInventory.get(index).getQuantity() - myItem.getQuantity());
				if (myInventory.get(index).getQuantity() < 1) {
					myInventory.remove(index);
					return myItem;
				}
			}
			index++;
		}
		return null;
	}
}
