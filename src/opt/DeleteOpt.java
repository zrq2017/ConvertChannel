package opt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conn.DMConnect;
/**
 * 隐通道删除操作
 * @author zrq
 *
 */
public class DeleteOpt {

	/**
	 * 删除user记录
	 * @param con
	 * @param id
	 * @return
	 */
	public static int deleteEmployee(Connection con,int id) {
		int tag=0;
		String sql="delete from 'PAY'.'employee' where id=?";
		PreparedStatement stmt=null;
		try {
			stmt=con.prepareStatement(sql);
			stmt.setInt(0, id);
			tag=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DMConnect.close(null,stmt,null);
		}
		return tag;
	}

	/**
	 * 删除saraly记录
	 * @param con
	 * @param id
	 * @return
	 */
	public static int deleteSaraly(Connection con,int id) {
		int tag=0;
		String sql="delete from 'PAY'.'payroll' where id=?";
		PreparedStatement stmt=null;
		try {
			stmt=con.prepareStatement(sql);
			stmt.setInt(0, id);
			tag=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DMConnect.close(null,stmt,null);
		}
		return tag;
	}
}
