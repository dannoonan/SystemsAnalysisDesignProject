package ie.demo.domain;

import java.io.Serializable;

public class User implements Serializable{

	private int userId;
	private int studentCardId;
	private int userTypeId;
	private String userName;
	private String password;
	private String email;
	private boolean isBanned;
	
	public User() {
	}
	public User(String username, String password, int studentCardId, String email, int userTypeId) {
		this.userName = username;
		this.password = password;
		this.studentCardId = studentCardId;
		this.email = email;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isBanned() {
		return isBanned;
	}
	public void setBanned(boolean banned) {
		this.isBanned = banned;
	}
	public long getStudentCardId() {
		return studentCardId;
	}
	public void setStudentCardId(int studentCardId) {
		this.studentCardId = studentCardId;
	}
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
