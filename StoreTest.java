package store;


public class StoreTest {

	public static void main(String[] args) {
		// Create a Store object called galmart
		Store galmart = new Store();
		
		// Create several customers, and have them each pick up several items to buy
		Customer peter = new Customer("Peter");
		Customer parker = new Customer("Parker");
		Customer stark = new Customer("Stark");
		
		peter.pickUpItemToBuy("diary");
		peter.pickUpItemToBuy("pen");
		peter.pickUpItemToBuy("mask");
		
		parker.pickUpItemToBuy("helmet");
		parker.pickUpItemToBuy("gun");
	
		stark.pickUpItemToBuy("car");
		stark.pickUpItemToBuy("cake");
		stark.pickUpItemToBuy("wine");
		
		// Add the customers to different lanes of galmart
		try {
			galmart.addCustomerToLane(stark, 1);
			galmart.addCustomerToLane(parker, 1);
			galmart.addCustomerToLane(peter, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// Call allLanesScanOneItem many, many times, until all of the customers are finished
		// scanning all of their items
		galmart.allLanesScanOneItem();
		galmart.allLanesScanOneItem();
		galmart.allLanesScanOneItem();
		galmart.allLanesScanOneItem();
		galmart.allLanesScanOneItem();
		galmart.allLanesScanOneItem();
		galmart.allLanesScanOneItem();
		
	}
}
