package bd2.Muber.repositories;

import java.util.Collection;

import bd2.Muber.model.Travel;

public interface TravelRepository {

	Collection<Travel> findAllOpened();

	Travel retrieve(long id);

	long save(Object entity);

}
