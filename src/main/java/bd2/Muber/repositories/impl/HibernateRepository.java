package bd2.Muber.repositories.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bd2.Muber.repositories.Repository;

@Component(value = "repository")
abstract class HibernateRepository implements Repository {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public long save(Object entity) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(entity);
		return (Long) session.getIdentifier(entity);
	}

	@SuppressWarnings("unchecked")
	public <T> T retrieve(Class<T> entityClass, Serializable key) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from " + entityClass.getName() + " where id = :key");
		query.setParameter("key", key);
		return (T) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> entityClass) {
		return sessionFactory.getCurrentSession().createQuery("from " + entityClass.getName()).list();
	}

	public void delete(Object entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

}
