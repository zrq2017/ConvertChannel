package opt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InputOpt {
	
	/**
	 * 插入所有数据
	 * @param con
	 * @return
	 */
	public static int inputAll(Connection con) {
		int[] id= {666666,999999};
		String[] writeSql= {
				"insert 'PAY'.'employee'(id,name) values(?,'user')",
				"insert 'PAY'.'payroll'(id,year,month,salary) values(?,2018,12,8000)"
				};
		String[] selectSql={
				"select count(*) from 'PAY'.'employee' where id=?",
				"select count(*) from 'PAY'.'payroll' where id=?"
				};
		PreparedStatement stmt=null;
		try {
			for(int i=0;i<2;i++) {
				stmt=con.prepareStatement(selectSql[i]);
				for(int j=0;j<2;j++) {
					stmt.setInt(0, id[j]);
					if(stmt.executeQuery().next()) {//若是查询记录为空执行插入
						PreparedStatement wstmt=con.prepareStatement(writeSql[i]);
						wstmt.setInt(0, id[j]);
						while(!wstmt.execute());//执行不成功继续执行
						wstmt.close();
					};
				}
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
