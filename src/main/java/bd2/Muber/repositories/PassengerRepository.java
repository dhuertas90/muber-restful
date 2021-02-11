package bd2.Muber.repositories;

import java.util.Collection;

import bd2.Muber.model.Passenger;

public interface PassengerRepository {

	Collection<Passenger> findAll();

	Passenger retrieve(long id);

	long save(Object entity);

}
