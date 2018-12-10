package user;

import java.sql.Connection;

import opt.DeleteOpt;
import opt.InputOpt;
import opt.SelectOpt;
/**
 * 数据库高安全级用户bean
 * @author zrq
 *
 */
public class Higher extends User implements Runnable{
	private Connection con;
	
	public Higher() {
		this.setLevel("high");
		this.setCon();
	}
	
	public Connection getCon() {
		return con;
	}
	public void setCon() {
		this.con = this.getCon0("SYSDBA", "123456789");
	}
	
	/**
	 * H用户传输数据并设置传送单个数据完毕状态
	 * @return
	 */
	public void dataOpt(int code) {
		if(code==1) {//H用0表示不删除，1表示删除；L在进行employee.B的插入时，插入不成功即数据存在读0，插入成功即数据不存在读1
			DeleteOpt.deleteEmployee(getCon(), 999999);//H操作Salary.B进行数据准备
		}
		DeleteOpt.deleteSaraly(getCon(), 666666);//H删除Saraly.A表示传送完数据
	}

	@Override
	public void run() {
		int code=0;//H第一次传送数据，无需在循环外写
		int len=7;
		int[] cipher= {1,0,1,0,1,0,1};
		while(true) {
			if(SelectOpt.SelectSaralyA(getCon())) {//H根据Salary.A记录是否存在判断L是否读取完毕数据
//				try {
//					Thread.sleep(1);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}//阻塞H执行
				this.dataOpt(cipher[len-1]);//H成功获取L读取完毕，重新进行数据的传输操作
				len--;
			}
			//在这用是否读取完毕判断是否终止循环
			if(len==0) {
				return;
			}
			System.out.println("H执行中...");
		}
	}
}
