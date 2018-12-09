package opt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectOpt {
	
	/**
	 * 查询Salary.A的记录是否存在
	 * @param con
	 * @return
	 */
	public static boolean SelectSaralyA(Connection con) {
		boolean tag=false;
		String sql="select count(*) from 'PAY'.'employee' where id=666666";
		try {
			tag=con.createStatement().executeQuery(sql).next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tag;
	}
}
