import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {


	private Buyer bb1;
	private Buyer bb2;
	private Seller s1;
	private Seller s2;
	private Category cate1;
	private Category cate2;
	private Item item1;
	private Item item2;
	private Bid b1;
	private Bid b2;




	ArrayList<Account> accList = new ArrayList<Account>();
	ArrayList<Category> categoryList = new ArrayList<Category>();
	ArrayList<Item> itemList = new ArrayList<Item>();
	ArrayList<Bid> bidsList = new ArrayList<Bid>();

	DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public C206_CaseStudyTest() {
		super();
	}


	//Issue 1
	@Test
	public void addBuyerTest() {

		// Account list is not null, so that can add a new account - boundary
		assertNotNull("Test if there is valid Account arraylist to retrieve item", accList);

		C206_CaseStudy.addBuyer(accList,bb1);

		//Given an empty list, after adding 1 buyer, the size of the list is 1 - normal
		//The buyer just added is as same as the first item of the list
		assertEquals("Check that account arraylist size is 1", 1, accList.size());
		assertSame("Check that buyer account is added", bb1, accList.get(0));

		//Add another buyer . test The size of the list is 2? -normal
		//The buyer just added is as same as the second buyer of the list
		C206_CaseStudy.addBuyer(accList,bb2);
		assertEquals("Check that account arraylist size is 2", 2, accList.size());
		assertSame("Check that buyer account is added", bb2, accList.get(1));
	}
	@Test
	public void addSellerTest() {

		// Account list is not null, so that can add a new account - boundary
		assertNotNull("Test if there is valid Account arraylist to retrieve item", accList);

		C206_CaseStudy.addSeller(accList,s1);

		//Given an empty list, after adding 1 seller, the size of the list is 1 - normal
		//The seller just added is as same as the first item of the list
		assertEquals("Check that account arraylist size is 1", 1, accList.size());
		assertSame("Check that seller account is added", s1, accList.get(0));

		//Add another seller . test The size of the list is 2? -normal
		//The seller just added is as same as the second buyer of the list
		C206_CaseStudy.addSeller(accList,s2);
		assertEquals("Check that account arraylist size is 2", 2, accList.size());
		assertSame("Check that seller account is added", s2, accList.get(1));
	}
	@Test
	public void retrieveAllUserTest() {

		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Item arraylist to retrieve item", itemList);


		String allAcc = C206_CaseStudy.retrieveAllUser(accList);
		String testOutput = "";
		assertEquals("Check that viewAllAccount list", testOutput, allAcc);

		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addBuyer(accList,bb1);
		C206_CaseStudy.addSeller(accList,s1);

		assertEquals("Test that Item arraylist size is 2?", 2, accList.size());

		//test if the expected output string same as the list of item retrieved 	
		allAcc = C206_CaseStudy.retrieveAllUser(accList);

		testOutput = String.format("%-10s %-10s %-15s %-10d \n", "Jay","Buyer","Jay@gmail.com",1234567);
		testOutput += String.format("%-10s %-10s %-15s %-10d \n", "Jenny","Seller","Jenny@gmail.com",7897890);

		assertEquals("Test that viewAllAccount list", testOutput, allAcc);
	}
	@Test
	public void doDeleteAccTest() {
		//C206_CaseStudy.deleteAcc(accList);
		//boundary
		assertNotNull("Test if there is valid Account arraylist to retrieve item", accList);

		C206_CaseStudy.addBuyer(accList,bb1);
		C206_CaseStudy.addSeller(accList,s1);
		
		
		String deleteEmail = "Jay@gmail.com";
		String deleteEmail2 = "Jenny@gmail.com";
		
		
		C206_CaseStudy.doDeleteAcc(accList, deleteEmail);
		//Given an list of 2 account, after removing 1 account, the size of the list is 1 - normal
		//The account just delete is remove and second item is same as the first item of the list
		assertEquals("Check that Acoount arraylist size is 1", 1, accList.size());
		assertSame("Check that a Account is removed", s1, accList.get(0));

		C206_CaseStudy.doDeleteAcc(accList, deleteEmail2);
		//Given an list of 2 account, after removing 1 account, the size of the list is 0 - normal
		assertEquals("Check that Account arraylist size is 0", 0, accList.size());
		
		//error condition , if account does not exist cannot delete 
		boolean delete = C206_CaseStudy.doDeleteAcc(accList, "jojo@gmail.com");
		assertFalse("Test that non-esiting item is NOT ok to delete", delete);
	}


	//Issue 2
	@Test
	public void addCategoryTest() {
		assertNotNull("Test if there is valid Category arraylist to retrieve item", categoryList);

		C206_CaseStudy.addCategory(categoryList, cate1);
		//Given an empty list, after adding 1 category, the size of the list is 1 - normal
		//The category just added is as same as the first item of the list
		assertEquals("Check that Category arraylist size is 1", 1, categoryList.size());
		assertSame("Check that Category is added", cate1, categoryList.get(0));

		C206_CaseStudy.addCategory(categoryList, cate2);
		//Given an empty list, after adding 1 category, the size of the list is 1 - normal
		//The category just added is as same as the first item of the list
		assertEquals("Check that Category arraylist size is 1", 2, categoryList.size());
		assertSame("Check that Category is added", cate2, categoryList.get(1));

	}
	@Test
	public void retrieveAllCategoryTest() {
		assertNotNull("Test if there is valid category arraylist to retrieve item", categoryList);

		//test if the list of category retrieved is empty -Boundary
		String allCat = C206_CaseStudy.retrieveAllCategory(categoryList);
		String testOutput = "";
		assertEquals("Check that ViewAllCategory list", testOutput, allCat);

		//Given an empty list, after adding 2 category, test if the size of the list is 2 - normal
		C206_CaseStudy.addCategory(categoryList, cate1);
		C206_CaseStudy.addCategory(categoryList, cate2);
		assertEquals("Test that category arraylist size is 2?", 2, categoryList.size());

		//test if the expected output string same as the list of category retrieved 	
		allCat = C206_CaseStudy.retrieveAllCategory(categoryList);

		testOutput = String.format("%s \n", "PETS");
		testOutput += String.format("%s \n", "FRUITS");

		assertEquals("Test that ViewAllCategory list", testOutput, allCat);
	}
	
	@Test
	public void doDeleteCategoryTest() {
		assertNotNull("Test if there is valid Category arraylist to retrieve item", categoryList);

		C206_CaseStudy.addCategory(categoryList, cate1);
		C206_CaseStudy.addCategory(categoryList, cate2);
		
		String deleteCat = "PETS";
		String deleteCat2 = "FRUITS";

		C206_CaseStudy.doDeleteCategory(categoryList, deleteCat);
		//Given an list of 2 category, after removing 1 category, the size of the list is 1 - normal
		//The item just delete is remove and second category is same as the first item of the list
		assertEquals("Check that category arraylist size is 1", 1, categoryList.size());
		assertSame("Check that a Category is removed", cate1, categoryList.get(0));

		C206_CaseStudy.doDeleteCategory(categoryList, deleteCat2);
		//Given an list of 1 category, after removing 1 category, the size of the list is 0 - normal
		//The item just delete is remove and second category is same as the first item of the list
		assertEquals("Check that category arraylist size is 0", 0, categoryList.size());
	}


	//Issue 3
	@Test
	public void addItemTest() {
		assertNotNull("Test if there is valid Item arraylist to retrieve item", itemList);

		C206_CaseStudy.addItem(itemList, item1);
		assertEquals("Check that items arraylist size is 1", 1, itemList.size());
		assertSame("Check that items is added", item1, itemList.get(0));

		C206_CaseStudy.addItem(itemList, item2);
		assertEquals("Check that items arraylist size is 1", 2, itemList.size());
		assertSame("Check that items is added", item2, itemList.get(1));

	}
	@Test
	public void retrieveAllItemTest() {
		assertNotNull("Test if there is valid Item arraylist to retrieve item", itemList);

		//test if the list of item retrieved is empty -Boundary
		String allItem = C206_CaseStudy.retrieveAllItem(itemList);
		String testOutput = "";
		assertEquals("Check that ViewAllItem list", testOutput, allItem);

		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addItem(itemList, item1);
		C206_CaseStudy.addItem(itemList, item2);
		assertEquals("Test that Item arraylist size is 2?", 2, itemList.size());

		//test if the expected output string same as the list of item retrieved 	
		allItem = C206_CaseStudy.retrieveAllItem(itemList);

		testOutput = String.format("%-10s %-20s %-10.2f %-15s %-15s %-10.2f \n", "DOG", "my pet", 50.00, LocalDate.parse("10/01/1980", formatter2),
				LocalDate.parse("01/01/2010", formatter2), 5.00);
		testOutput += String.format("%-10s %-20s %-10.2f %-15s %-15s %-10.2f \n", "CAT", "my pet", 50.00, LocalDate.parse("10/01/1980", formatter2),
				LocalDate.parse("01/01/2010", formatter2), 5.00);

		assertEquals("Test that ViewAllItem list", testOutput, allItem);
	}
	@Test
	public void doDeleteItemTest() {
		
		assertNotNull("Test if there is valid Item arraylist to retrieve item", itemList);

		C206_CaseStudy.addItem(itemList, item1);
		C206_CaseStudy.addItem(itemList, item2);
		String deleteName = "Dog";
		String deleteName2 = "Cat";

		C206_CaseStudy.doDeleteItem(itemList, deleteName);
		//Given an list of 2 item, after removing 1 item, the size of the list is 1 - normal
		//The item just delete is remove and second item is same as the first item of the list
		assertEquals("Check that Item arraylist size is 1", 1, itemList.size());
		assertSame("Check that a Item is removed", item2, itemList.get(0));

		C206_CaseStudy.doDeleteItem(itemList, deleteName2);
		//Given an list of 1 item, after removing 1 item, the size of the list is 0 - normal
		//The item just delete is remove and second item is same as the first item of the list
		assertEquals("Check that item arraylist size is 0", 0, itemList.size());
	}

	//Issue 4
	@Test
	public void addBidTest() {
		assertNotNull("Test if there is valid Bid arraylist to retrieve item", bidsList);

		C206_CaseStudy.addBid(bidsList,b1);
		//Given an empty list, after adding 1 bid, the size of the list is 1 - normal
		//The bid just added is as same as the first bid of the list
		assertEquals("Check that bids arraylist size is 1", 1, bidsList.size());
		assertSame("Check that bids is added", b1, bidsList.get(0));

		//Add another bid, test The size of the list is 2? -normal
		//The bid just added is as same as the second item of the list
		C206_CaseStudy.addBid(bidsList,b2);
		assertEquals("Check that bids arraylist size is 2", 2, bidsList.size());
		assertSame("Check that bid is added", b2, bidsList.get(1));
	}
	@Test
	public void retrieveAllBidsTest() {
		assertNotNull("Test if there is valid Bid arraylist to retrieve item", bidsList);

		//test if the list of bids retrieved is empty - boundary
		String allBids = C206_CaseStudy.retrieveAllBids(bidsList);
		String testOutput = "";
		assertEquals("Check that ViewAllBids list", testOutput, allBids);

		//Given an empty list, after adding 2 bids, test if the size of the list is 2 - normal
		C206_CaseStudy.addBid(bidsList, b1);
		C206_CaseStudy.addBid(bidsList, b2);
		assertEquals("Test that Bids arraylist size is 2?", 2, bidsList.size());

		//test if the expected output string same as the list of bid retrieved 	
		allBids = C206_CaseStudy.retrieveAllBids(bidsList);

		testOutput = String.format("%-10d %-10s %-15s %-20s %-10.2f \n", 1, "Dog", "happy@gmail.com", "sam@gmail.com", 50.00);
		testOutput += String.format("%-10d %-10s %-15s %-20s %-10.2f \n", 2, "Cat", "kkq@gmail.com", "sammy@gmail.com", 60.00);

		assertEquals("Test that ViewAllBids list", testOutput, allBids);

	}
	@Test
	public void doDeleteBidsTest() {
		assertNotNull("Test if there is valid Bid arraylist to retrieve item", bidsList);

		C206_CaseStudy.addBid(bidsList,b1);
		C206_CaseStudy.addBid(bidsList,b2);
		int deleteId = 1;
		int deleteId2 = 2;
		
		C206_CaseStudy.doDeleteBids(bidsList,deleteId);
		//Given an list of 2 bids, after removing 1 item, the size of the list is 1 - normal
		//The item just delete is remove and second item is same as the first item of the list
		assertEquals("Check that Bids arraylist size is 1", 1, bidsList.size());
		assertSame("Check that a Bid is remove", b2, bidsList.get(0));

		C206_CaseStudy.doDeleteBids(bidsList,deleteId2);
		//Given an list of 1 bids, after removing 1 item, the size of the list is 0 - normal
		//The item just delete is remove and second item is same as the first item of the list
		assertEquals("Check that Bids arraylist size is 0", 0, bidsList.size());
		
		// error condition, if bid ID does not exist , cannot delete 
		boolean delete = C206_CaseStudy.doDeleteBids(bidsList,4);
		assertFalse("Test that non-esiting bid is NOT ok to delete",delete);
	}

	//Issue 5

	@Before
	public void setUp() throws Exception {
		//prepare test data 
		item1 = new Item("DOG", "my pet", 50.00, LocalDate.parse("10/01/1980", formatter2),
				LocalDate.parse("01/01/2010", formatter2), 5.00);
		item2 = new Item("CAT", "my pet", 50.00, LocalDate.parse("10/01/1980", formatter2),
				LocalDate.parse("01/01/2010", formatter2), 5.00);
		b1 = new Bid(1, "Dog", "happy@gmail.com", "sam@gmail.com", 50.00);
		b2 = new Bid(2, "Cat", "kkq@gmail.com", "sammy@gmail.com", 60.00);

		bb1 = new Buyer("Jay","Buyer","Jay@gmail.com",1234567);
		bb2 = new Buyer("Sam","Buyer","Sam@gmail.com",7654321);
		s1 = new Seller("Jenny","Seller","Jenny@gmail.com",7897890);
		s2 = new Seller("ken","Seller","ken@gmail.com",0001234);

		cate1 = new Category("PETS");
		cate2 = new Category("FRUITS");
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
