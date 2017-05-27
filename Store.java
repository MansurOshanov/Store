package store;

import csci152.adt.*;
import csci152.impl.*;

/* Class used to represent a store with three check-out lanes */

public class Store {

	private StoreLane[] lanes;
	
	public Store() {
		lanes = new StoreLane[3];
		for (int i = 0; i < 3; ++i) {
			lanes[i] = new StoreLane(i);
		}
	}

	/* Adds the given customer to the given lane; an exception is thrown if laneNum is
 	not 1, 2, or 3 */
	public void addCustomerToLane(Customer c, int laneNum) throws Exception {
		if (laneNum != 1 && laneNum != 2 && laneNum != 3) {
			throw new Exception("No such lane. Enter correct lane number");
		}
		lanes[laneNum - 1].addNewCustomer(c);
	}
	
	/* All three lanes scan an item */
	public void allLanesScanOneItem() {
		for (int i = 0; i < 3; i++) {
			lanes[i].scanOneItem();
		}
	}
}
