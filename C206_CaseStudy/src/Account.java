/**
 * 
 */
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20012122, 1 Aug 2021 20:17:43
 */

/**
 * @author 20012122
 *
 */
public class Account {
	
	private String name;
	private String role;
	private String email;
	private int password;
	
	public Account(String name, String role, String email, int password) {
		this.name = name;
		this.role = role;
		this.email = email;
		this.password = password;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public String 
	getRole() {
		return role;
	}

	
	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPassword() {
		return password;
	}


	public void setPassword(int password) {
		this.password = password;
	}
	public String toString() {
		String userInfo = String.format("%-10s %-10s %-15s %-10d", 
				name, role,email,password);
		
		return userInfo;
	}
	

}//
