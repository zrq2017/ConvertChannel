package opt;

import user.Higher;
import user.Lower;

public class ALLOpt {
	public void excute() {
		Lower low=new Lower();
		Higher high=new Higher();
		//1.L写所有记录
		InputOpt.inputAll(low.getCon());
		//2.L删除User.A的记录
		DeleteOpt.deleteEmployee(low.getCon(), 666666);
		//3.H操作Salary.B进行数据准备
		DeleteOpt.deleteSaraly(high.getCon(), 0);
		//4.H删除Saraly.A表示传送完数据
		DeleteOpt.deleteSaraly(high.getCon(), 666666);
		//5.L一直在删除A，此时删除成功
		DeleteOpt.deleteEmployee(low.getCon(), 666666);
		//6.L删除User.B读取数据
		DeleteOpt.deleteEmployee(low.getCon(), 999999);
		//7.L补全所有记录
		InputOpt.inputAll(low.getCon());
		//8.H删除后一直读Saraly.A的记录，判断是否读数据成功
		//L读数据成功，H重复3的操作，新一轮数据准备
		while(SelectOpt.SelectSaralyA(high.getCon())) {
			System.out.println("L读数据完毕，新一轮已开始！");
		};
	}
}
