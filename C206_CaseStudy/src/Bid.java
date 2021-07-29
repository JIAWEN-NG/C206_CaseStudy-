import java.util.Date;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20011454, Jul 29, 2021 9:32:55 PM
 */

/**
 * @author 20011454
 *
 */
public class Bid {

	private int id;
	private String name;
	private String sellerEmail;
	private String buyerEmail;
	private double price;
	
	public Bid(int id, String name, String sellerEmail, String buyerEmail, double price) {
		this.id = id;
		this.name = name;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public String toString() {
		String itemInfo = String.format("%-10s %-20s %-15s %-15s %-10.2f", 
				id, name, sellerEmail, buyerEmail, price);
		
		return itemInfo;
	}
	


}
