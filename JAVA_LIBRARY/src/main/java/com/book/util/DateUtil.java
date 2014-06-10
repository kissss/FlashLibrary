package com.book.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author 王磊
 * @date 2013年4月9日 09:59:50
 * @describe 日期处理类
 * 
 */
public class DateUtil
{

	/**
	 * @param date
	 * @return 2013-04-09
	 */
	public static String dateFormater(Date date)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String str = format.format(date);
		return str;
	}

	/**
	 * 
	 * @param date
	 * @return 2013年04月09日
	 */
	public static String dateFormater2(Date date)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
		String str = format.format(date);
		return str;
	}

	/**
	 * 
	 * @param date
	 * @return 2013-04-09 10:01:15
	 */
	public static String dateTimeFormater(Date date)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = format.format(date);
		return str;
	}

	/**
	 * 根据日期格式 得到当前日期的月份、 格式是 yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static Integer getMouth(String date)
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		int month = 0;
		try
		{
			Date date1 = simpleDateFormat.parse(date);
			cal.setTime(date1);

			month = cal.get(Calendar.MONTH);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return month + 1;
	}

	/**
	 * 根据当前时间 和 需要加上的天数 并返回 加上天数后的 日期 格式为：2013-06-11
	 * @param date
	 *            当前时间
	 * @param day
	 *            需要加上的天数
	 * @return
	 */
	public static String addDate(Date date, long day)
	{

		long time = date.getTime();
		day = day * 24 * 60 * 60 * 1000;
		time += day;
		return dateFormater(new Date(time));
	}

	/**
	 * 得到两个日期之差 格式为:yyyy-MM-dd
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getBetweenDate(String date1, String date2)
	{
		try
		{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dateFirst;
			dateFirst = simpleDateFormat.parse(date1);
			Date dateSecond = simpleDateFormat.parse(date2);

			long dmm = dateFirst.getTime() - dateSecond.getTime();

			return (int) dmm / 1000 / 60 / 60 / 24;
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return 0;

	}

}
