/**
 * 
 */
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20012122, 1 Aug 2021 20:23:33
 */

/**
 * @author 20012122
 *
 */
public class Seller extends Account {
	
	private boolean notification;


	public Seller(String name, String role, String email, int password) {
		super(name, role, email, password);
		this.notification = true;
	}
	
	public boolean getNotification() {
		return notification;
	}

	public void setNotification(boolean notification) {
		this.notification = notification;
	}

	public String toString(){
		String output = super.toString();
		return output;
	}

}
