package store;

import csci152.adt.Queue;
import csci152.impl.ArrayQueue;

/* Represents a single check-out lane in a store */

public class StoreLane {
	
	private int laneNumber;
	private Queue<Customer> line;
	private Customer beingServed;
	
	public StoreLane(int i) {
		line = new ArrayQueue();
		this.laneNumber = i + 1;
	}
	
	/* If nobody is currently being served, then c will be served immediately; otherwise, c will be
 	added to the queue; this should also output a message saying that c has entered this lane */
	public void addNewCustomer(Customer c) {
		if (beingServed == null) {
			beingServed = c;
		} else {
			line.enqueue(c);
		}
		System.out.println("Customer: " + c.getName() + " entered lane " + laneNumber);
	}
	
	/* If there is a customer being served, scan one of their items; After the scanning, if the
	customer has no more items, output a message saying that the customer is finished, and
	then replace the customer being served with the next customer in the queue, and output a
	message saying the new customer is being served. However, if the queue is empty at this
	point, then simply set beingServed to null */
	public void scanOneItem() {
		if (beingServed != null) {
			beingServed.scanOneItem(laneNumber);
		
			if (beingServed.noItemsLeft() == true) {
				System.out.println("Customer: " + beingServed.getName() + " finished");
			
				if (line.getSize() == 0) {
					beingServed = null;
				} else {
					try {
						beingServed = line.dequeue();
						System.out.println("New customer: " + beingServed.getName() + " being served at lane " + laneNumber);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			
			}
		}
	}
}
