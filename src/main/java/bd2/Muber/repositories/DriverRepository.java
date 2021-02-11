package bd2.Muber.repositories;

import java.util.Collection;

import bd2.Muber.model.Driver;

public interface DriverRepository {

	Collection<Driver> findAll();

	Driver retrieve(long id);

	Collection<Driver> findTopTen();

}
