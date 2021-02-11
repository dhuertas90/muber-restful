package bd2.Muber.repositories;

import java.io.Serializable;
import java.util.List;

public interface Repository {

	long save(Object entity);

	void delete(Object entity);

	<T> List<T> findAll(Class<T> entityClass);

	<T> T retrieve(Class<T> entityClass, Serializable key);

}
