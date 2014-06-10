package date.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateTest
{

	public static Date addDate(Date d, long day) throws Exception
	{

		long time = d.getTime();
		day = day * 24 * 60 * 60 * 1000;
		time += day;
		return new Date(time);

	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		/*
		 * java.util.Date dt=new java.util.Date(); System.out.println(dt); //输出结果是：Wed Aug 10 11:29:11 CST 2005
		 * 
		 * SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); System.out.print(sdf.format(dt) + 12);
		 */
		Date d = new Date();

		Date newDate = addDate(d, 12);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(dateFormat.format(d));
		System.out.println(dateFormat.format(newDate));

	}

	@Test
	public void testDate()
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		int month = 0;
		try
		{
			Date date1 = simpleDateFormat.parse("2013-04-22");
			Date date2 = simpleDateFormat.parse("2013-05-04");
			
			long dmm=date1.getTime()-date2.getTime();
			
			int d =(int) dmm/1000/60/60/24;
			System.out.println(d);
//			cal.setTime(date1);

//			month = cal.get(Calendar.);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
	}
}