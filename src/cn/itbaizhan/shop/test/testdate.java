package cn.itbaizhan.shop.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class testdate {
	
	@Test
	public void test() {
		Date date = new Date();
		String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
		System.out.println(dateStr);
		
	}
	@Test
	public void test1() {
		String a = "LOAD CLIENT FROM ${newnp}.bak OF DEL MODIFIED BY DUMPFILE=${_lsnp} NOCHARDEL COLDEL| METHOD \\\r\n" + 
				"				  P (1,2,3,4,5) \\\r\n" + 
				"				  MESSAGES  T_NATURALPERSON.log  REPLACE INTO T_NATURALPERSON FOR EXCEPTION T_NATURALPERSON_T \\\r\n" + 
				"				  NONRECOVERABLE INDEXING MODE AUTOSELECT SET INTEGRITY PENDING CASCADE IMMEDIATE LOCK WITH FORCE\"";
		String b = a.toLowerCase();
		System.out.println(b);
		
	}

}
