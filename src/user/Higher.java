package user;

import java.sql.Connection;

public class Higher extends User{
	private Connection con;
	
	public Higher() {
		this.setLevel("high");
		this.setCon();
	}
	
	public Connection getCon() {
		return con;
	}
	public void setCon() {
		this.con = this.getCon("high", "123456789");
	}
}
