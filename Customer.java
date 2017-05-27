package store;

import csci152.adt.*;
import csci152.impl.ArrayQueue;

/* Used to represent customers in a store */

public class Customer {
	
	private String name;
	private Queue<String> itemsToScan;
	
	public Customer(String name) {
		this.itemsToScan = new ArrayQueue();
		this.name = name;
	}
	
	/* Adds the given item name to the queue. */
	public void pickUpItemToBuy(String itemName) {
		itemsToScan.enqueue(itemName);
	}
	
	/* Removes the first item from the queue, and output a message saying what has been
 	scanned, and for which customer */
	public void scanOneItem(int bufLane) {
		try {
			String temp = itemsToScan.dequeue();
			System.out.println("At lane " + bufLane + ": " + temp + " was scanned. For customer: " + name);
		} catch (Exception e) {
			e.printStackTrace();;
		}
	}
	
	/* Returns true if and only if the customer has no items left to scan */
	public boolean noItemsLeft() {
		if (itemsToScan.getSize() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getName() {
		return name;
	}
}
