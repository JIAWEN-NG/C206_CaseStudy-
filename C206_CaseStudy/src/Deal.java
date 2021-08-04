
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * {Izhar Malik}, {19/04/2021} {10:08 am}
 */

public class Deal {
	
	private int dealId;
	private String name;
	private String sellerEmail;
	private String buyerEmail;
	private double transactionPrice;
	private String closeDate;
	
	public Deal(int dealId, String name, String sellerEmail, String buyerEmail, double transactionPrice, String closeDate) {
		this.dealId = dealId;
		this.name = name;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail;
		this.transactionPrice = transactionPrice;
		this.closeDate = closeDate;
		
	}
		
		public int getdealId() {
			return dealId;
		}

		public void setdealId(int dealId) {
			this.dealId = dealId;
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


		public double getTransactionPrice() {
			return transactionPrice;
		}

		public void setTransactionPrice(double transactionPrice) {
			this.transactionPrice = transactionPrice;
		}
		
		public String getCloseDate() {
			return closeDate;
		}
		
		public void setCloseDate(String closeDate) {
			this.closeDate = closeDate;
		}
		
		public String toString() {
			String itemInfo = String.format("%-10s %-10s %-15s %-20s %-10.2f", 
					dealId, name, sellerEmail, buyerEmail, transactionPrice, closeDate);
			
			return itemInfo;
		}

}
