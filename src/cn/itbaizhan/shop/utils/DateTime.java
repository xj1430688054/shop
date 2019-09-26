package cn.itbaizhan.shop.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 	获取当期时间的类
 * @author Administrator
 *
 */
public class DateTime {
	private List<Date> festival = new ArrayList<Date>();// 节假日
	 private List<Date> workDay = new ArrayList<Date>();// 工作日
	
	public static Date getDate() {
		 SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        String date2=temp.format(new Date());  
        Date date3 = null;
		try {
			date3 = temp.parse(date2);
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return date3;
	}
	
	/**
	  * 判断一个日期是否日节假日 法定节假日只判断月份和天，不判断年
	  * 
	  * @param date
	  * @return
	  */
	 public boolean isFestival(Date date) {
	  boolean festival = false;
	  Calendar fcal = Calendar.getInstance();
	  Calendar dcal = Calendar.getInstance();
	  dcal.setTime(date);
	  List<Date> list = this.getFestival();
	  for (Date dt : list) {
	   fcal.setTime(dt);

	   // 法定节假日判断
	   if (fcal.get(Calendar.MONTH) == dcal.get(Calendar.MONTH)
	     && fcal.get(Calendar.DATE) == dcal.get(Calendar.DATE)) {
	    festival = true;
	   }
	  }
	  return festival;
	 }

	public List<Date> getFestival() {
		return festival;
	}

	public void setFestival(List<Date> festival) {
		this.festival = festival;
	}

	public List<Date> getWorkDay() {
		return workDay;
	}

	public void setWorkDay(List<Date> workDay) {
		this.workDay = workDay;
	}
	 
	 
}
