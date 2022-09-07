package uril;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期格式化基础类
 * 
 * @author Chiang
 */
public class DateFormatUtil {

	/**
	 * 格式化日期为yyyy-MM-dd.  
	 * 日期转串
	 * @param date
	 * @return String
	 */
	public static String FormatDate(Date date) {
		if (date != null)
			return new SimpleDateFormat("yyyy-MM-dd").format(date);
		else
			return "";
	}
	
	/**
	 * 格式化日期为yyyy-MM-dd.
	 * 日期转串
	 * @param date
	 * @return String
	 */
	public static String FormatDate(java.sql.Date date) {
		Date javaDate = new Date(date.getTime());
		return new SimpleDateFormat("yyyy-MM-dd").format(javaDate);
	}	

	/**
	 * 格式化日期为yyyy-MM-dd HH:mm.
	 * 日期转串
	 * @param date
	 * @return String
	 */
	public static String FormatTime(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
	}

	/**
	 * 格式化日期为yyyy-MM-dd HH:mm.
	 * 日期转串
	 * @param date
	 * @return String
	 */
	public static String FormatTime(java.sql.Date date) {
		Date javaDate = new Date(date.getTime());
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(javaDate);
	}
	
	/**
	 * 格式化日期为指定格式.
	 * 
	 * @param date
	 * @throws Exception
	 * @return String
	 */
	public static String Format(Date date, String simple) throws Exception {
		if (date != null) {
			try {
				return new SimpleDateFormat(simple).format(date);
			} catch (Exception ex) {
				throw new Exception("Exception at Format " + simple + "格式不正确" + ex);
			}
		} else {
			return "";
		}
	}

	/**
	 * 格式化日期为指定格式.
	 * 
	 * @param date
	 * @throws Exception
	 * @return String
	 */
	public static String Format(java.sql.Date date, String simple) throws Exception {
		Date javaDate = new Date(date.getTime());
		if (date != null) {
			try {
				return new SimpleDateFormat(simple).format(javaDate);
			} catch (Exception ex) {
				throw new Exception("Exception at Format " + simple + "格式不正确" + ex);
			}
		} else {
			return "";
		}
	}



	/**
	 * yyyy-MM-dd字符串格式化为java.util.Date
	 * 
	 * @param source
	 * @throws Exception
	 * @return java.util.Date
	 */
	public static Date FormatDateString(String source) throws Exception {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(source);
		} catch (ParseException ex) {
			throw new Exception("Exception at ForamteDateString 日期输入格式不是符合 yyyy-MM-dd" + ex.toString());
		}
	}

	/**
	 * yyyy-MM-dd HH:mm:ss字符串格式化为java.util.Date
	 * 
	 * @param source
	 * @throws Exception
	 * @return java.util.Date
	 */
	public static Date FormatTimeString(String source) throws Exception {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
		} catch (ParseException ex) {
			throw new Exception("Exception at ForamteTimeString 日期输入格式不是符合 yyyy-MM-dd HH:mm:ss" + ex.toString());
		}
	}
	

	/**
	 * 字符串格式化为java.util.Date
	 * 
	 * @param source
	 *            字符串日期
	 * @param simple
	 *            格式
	 * @throws Exception
	 * @return java.util.Date
	 */
	public static Date ForamteString(String source, String simple) throws Exception {
		try {
			return new SimpleDateFormat(simple).parse(source);
		} catch (ParseException ex) {
			throw new Exception("Exception at ForamteTimeString 日期输入格式不是符合 " + simple + ex.toString());
		}
	}
	
	public static String getCurrentDateString () {
        //method 1  
        Calendar nowtime = new GregorianCalendar();  
        String strDateTime=String.format("%04d", nowtime.get(Calendar.YEAR))+
                String.format("%02d", nowtime.get(Calendar.MONTH))+  
                String.format("%02d", nowtime.get(Calendar.DATE))+ 
                String.format("%02d", nowtime.get(Calendar.HOUR))+ 
                String.format("%02d", nowtime.get(Calendar.MINUTE))+ 
                String.format("%02d", nowtime.get(Calendar.SECOND))+  
                String.format("%03d", nowtime.get(Calendar.MILLISECOND));  
        return strDateTime;  
	}
	
	public static void main(String[] args) {
//		System.out.println(DateFormatUtil.getCurrentDateString());;
		try {
			System.out.println(DateFormatUtil.Format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
