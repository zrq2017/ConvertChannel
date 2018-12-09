package user;

import java.sql.Connection;

public class Lower extends User{
	private Connection con;
	
	public Lower() {
		this.setLevel("low");
		this.setCon();
	}

	public Connection getCon() {
		return con;
	}

	public void setCon() {
		this.con = this.getCon("low", "123456789");
	}
}
