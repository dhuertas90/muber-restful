package bd2.Muber.repositories.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;

import bd2.Muber.model.Driver;
import bd2.Muber.repositories.DriverRepository;

public class HibernateDriverRepository extends HibernateRepository implements DriverRepository {

	public Collection<Driver> findAll() {
		return super.findAll(Driver.class);
	}

	public Driver retrieve(long id) {
		return super.retrieve(Driver.class, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<Driver> findTopTen() {

		String hql = "select driver, avg(rating.score) from Travel travel join travel.ratings rating join travel.driver driver group by driver.name order by avg(rating.score) desc";

		Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);

		List<Object[]> coleccion = query.setMaxResults(10).list();

		Collection<Driver> driverCollection = new HashSet<Driver>();
		for (Object[] line : coleccion) {
			driverCollection.add((Driver) line[0]);
		}

		return driverCollection;
	}

}
