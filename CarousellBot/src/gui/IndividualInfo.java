package gui;

public class IndividualInfo {
private String username;
private String keyword;
private String password;
	public void addInfo(String username, String keyword, String password) {
		this.username=username;
		this.keyword=keyword;
		this.password=password;
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
