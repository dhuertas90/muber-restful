package bd2.Muber.services;

import java.util.Collection;

import bd2.Muber.dto.driver.DriverDTO;

public interface DriverService {

	Collection<DriverDTO> getDrivers();

	DriverDTO getDriverById(long conductorId);

	Collection<DriverDTO> getTopTenDrivers();

}
