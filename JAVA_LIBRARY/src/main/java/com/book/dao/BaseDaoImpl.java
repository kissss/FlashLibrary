package com.book.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Administrator
 * @date 2013年4月17日 00:59:43
 * @param <T>
 */
@Component("baseDao")
public class BaseDaoImpl<T> implements BaseDaoI<T> {

	private SessionFactory sessionFactory;

	@Override
	public long count(String hql) {
		return (Long) this.sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
	}

	@Override
	public long count(String hql, Map<String, Object> params) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return (Long) query.uniqueResult();
	}

	@Override
	public void delete(T o) {
		this.sessionFactory.getCurrentSession().delete(o);
	}

	@Override
	public int executeHql(String hql) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		return query.executeUpdate();
	}

	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql) {

		return this.sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql, int start, int rows) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.setFirstResult(start).setMaxResults(rows).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql, Map<String, Object> params) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql, Map<String, Object> params, int start, int rows) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return query.setFirstResult(start).setMaxResults(rows).list();
	}

	@SuppressWarnings("unchecked")
	public T get(Class<T> c, Serializable id) {
		return (T) sessionFactory.getCurrentSession().get(c, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(String hql) {
		List<T> list = (List<T>) sessionFactory.getCurrentSession().createQuery(hql).list();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;

	}

	@Override
	@SuppressWarnings("unchecked")
	public T get(String hql, Map<String, Object> params) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		List<T> list = query.list();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(String hql, Object[] params) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		return (T) query.list().get(0);
	}

	@Override
	public Serializable save(T o) {
		return this.sessionFactory.getCurrentSession().save(o);
	}

	@Override
	public void saveOrUpdate(T o) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(o);
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void update(T o) {
		this.sessionFactory.getCurrentSession().update(o);
	}

}
