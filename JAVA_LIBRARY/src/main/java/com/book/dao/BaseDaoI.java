package com.book.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2013年4月17日 00:59:29
 * @param <T>
 */
public interface BaseDaoI<T> {

	/**
	 * 根据hql语句返回这个表中一共有多少条记录
	 * 
	 * @param hql
	 * @return
	 */
	public long count(String hql);

	/**
	 * 根据hql(带参数)语句返回这个表中一共有多少条记录
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public long count(String hql, Map<String, Object> params);

	/**
	 * 删除这个对象 也就是一条记录
	 * 
	 * @param o
	 */
	public void delete(T o);

	/**
	 * 执行这个hql语句
	 * 
	 * @param hql
	 * @return 受影响的行数
	 */
	public int executeHql(String hql);

	/**
	 * 执行带参数的 hql语句
	 * 
	 * @param hql
	 * @param params
	 *            一个map型 参数
	 * @return 受影响的行数
	 */
	public int executeHql(String hql, Map<String, Object> params);

	/**
	 * 根据hql语句返回所有的list
	 * 
	 * @param hql
	 * @return
	 */
	public List<T> find(String hql);

	/**
	 * 没有参数分页功能
	 * 
	 * @param hql
	 * @param page
	 *            当前从第一几条开始
	 * @param rows
	 *            条数 例如 10条 20条 等
	 * @return 当前对象List
	 */
	public List<T> find(String hql, int start, int rows);

	/**
	 * 执行带参数的 查找语句
	 * 
	 * @param hql
	 * @param params
	 * @return 当前对象的List集合
	 */
	public List<T> find(String hql, Map<String, Object> params);

	/**
	 * 带参数的分页功能
	 * 
	 * @param hql
	 * @param params
	 * @param page
	 *            当前页 第一页 第二页
	 * @param rows
	 *            需要返回多少条数 例如 10条 20条 30条
	 * @return
	 */
	public List<T> find(String hql, Map<String, Object> params, int start, int rows);

	/**
	 * 根据主键 返回这个对象
	 * 
	 * @param c
	 * @param id
	 *            主键
	 * @return
	 */
	public T get(Class<T> c, Serializable id);

	/**
	 * 根据hql语句得到该对象的list中第一个对象
	 */
	public T get(String hql);

	/**
	 * 根据 参数 返回这个对象
	 * 
	 * @param hql
	 * @param params
	 *            map型参数
	 * @return
	 */

	public T get(String hql, Map<String, Object> params);

	/**
	 * 根据 参数 返回这个对象
	 * 
	 * @param hql
	 * @param params
	 *            对象数组 例如 hql="from BookDate where id=?" 传入的参数为 get(hql,new
	 *            String[]{1,id的值})
	 * @return
	 */
	public T get(String hql, Object[] params);

	/**
	 * 保存这个对象
	 * 
	 * @param o
	 * @return
	 */
	public Serializable save(T o);

	/**
	 * 保存或者更新这个对象
	 * 
	 * @param o
	 */
	public void saveOrUpdate(T o);

	/**
	 * 更新这个对象
	 * 
	 * @param o
	 */
	public void update(T o);

}
