package Model;

public class PersonInfo {
	private String username;
	private String password;
	private String keyword;
	
	public  PersonInfo(String username,String password,String keyword) {
		this.username = username;
		this.password = password;
		this.keyword = keyword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
