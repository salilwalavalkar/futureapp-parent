package com.salil.futureapp.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * #HIBERNATE
 * @author salil
 *
 * @param <T>
 */
public abstract class AbstractHibernateDAO<T extends Serializable> {
	
	private Class<T> clazz;

	@Autowired
	SessionFactory sessionFactory;

	public void setClazz(final Class<T> clazzToSet) {
		clazz = clazzToSet;
	}

	@SuppressWarnings("unchecked")
	public T find(final Long id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + clazz.getName())
				.list();
	}

	public void save(final T entity) {
		getCurrentSession().persist(entity);
	}

	public void update(final T entity) {
		getCurrentSession().merge(entity);
	}


	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
