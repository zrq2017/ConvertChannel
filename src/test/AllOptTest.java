package test;

import org.junit.jupiter.api.Test;

import opt.DeleteOpt;
import opt.InputOpt;
import opt.SelectOpt;
import user.Higher;

class AllOptTest {

	@Test
	void testSelectOpt_SelectSaralyA() {
		System.out.println("testSelectOpt_SelectSaralyA:");
		System.out.println(SelectOpt.SelectSaralyA(new Higher().getCon()));
	}

	@Test
	void testInputOpt_inputAll() {
		System.out.println("testInputOpt_inputAll:");
		System.out.println(InputOpt.inputAll(new Higher().getCon()));
	}

	@Test
	void testInputOpt_inputEmployee() {
		System.out.println("testInputOpt_inputEmployee:");
		System.out.println(InputOpt.inputEmployee(new Higher().getCon(),999999));
	}

	@Test
	void testDeleteOpt_deleteEmployee() {
		System.out.println("testDeleteOpt_deleteEmployee:");
		System.out.println(DeleteOpt.deleteEmployee(new Higher().getCon(),666666));
	}
	
	@Test
	void testDeleteOpt_deleteSaraly() {
		System.out.println("testDeleteOpt_deleteSaraly:");
		System.out.println(DeleteOpt.deleteSaraly(new Higher().getCon(),666666));
	}
}
