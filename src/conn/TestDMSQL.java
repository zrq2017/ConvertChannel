package conn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestDMSQL {

	public static void selectSql() {
		Connection con = DMConnect.getConnection(DMConnect.JDBC_DRIVER, DMConnect.DB_URL, DMConnect.USER,
				DMConnect.PASS);
		String sql = "select * from PAY.'EMPLOYEE'";
		Statement stmt = DMConnect.getStatement(con);
		ResultSet rs = DMConnect.getResultSet(stmt, sql);
		try {
			String str = "";
			int i = 1;
			while (rs.next()) {
				str += i + ": ";
				str += rs.getString("id") + " ";
				str += rs.getString("name") + " ";
				str += rs.getDate("date") + "\n";
				i++;
			}
			System.out.println(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DMConnect.close(con, stmt, rs);
	}

	public static void deleteSql() {
		Connection con = DMConnect.getConnection(DMConnect.JDBC_DRIVER, DMConnect.DB_URL, DMConnect.USER,
				DMConnect.PASS);
		String sql = "delete from pay.employee";
		Statement stmt = DMConnect.getStatement(con);
		try {
			boolean t=stmt.execute(sql);
			System.out.println(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DMConnect.close(con, stmt, null);
	}

	public static void main(String[] args){
		System.out.println("************DM数据库语句测试**********\n");
		System.out.println("1.select\t2.delete");
		int i = new Scanner(System.in).nextInt();
		switch (i) {
		case 1:
			selectSql();
			break;
		case 2:
			deleteSql();
			break;
		}
	}

}
