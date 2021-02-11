package bd2.Muber.repositories.impl;

import java.util.Collection;

import bd2.Muber.model.Passenger;
import bd2.Muber.repositories.PassengerRepository;

public class HibernatePassengerRepository extends HibernateRepository implements PassengerRepository {

	public Collection<Passenger> findAll() {
		return super.findAll(Passenger.class);
	}

	public Passenger retrieve(long id) {
		return super.retrieve(Passenger.class, id);
	}

}
