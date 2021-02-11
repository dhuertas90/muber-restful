package bd2.Muber.repositories.impl;

import java.util.Collection;

import bd2.Muber.model.Travel;
import bd2.Muber.repositories.TravelRepository;

public class HibernateTravelRepository extends HibernateRepository implements TravelRepository {

	@SuppressWarnings("unchecked")
	public Collection<Travel> findAllOpened() {
		return this.getSessionFactory().getCurrentSession().createQuery("from Travel where open = true").list();
	}

	public Travel retrieve(long id) {
		return super.retrieve(Travel.class, id);
	}
}
