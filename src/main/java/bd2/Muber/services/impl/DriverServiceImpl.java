package bd2.Muber.services.impl;

import java.util.Collection;

import bd2.Muber.dto.driver.DriverDTO;
import bd2.Muber.model.Driver;
import bd2.Muber.services.DriverService;

public class DriverServiceImpl extends BaseServiceImpl implements DriverService {

	public Collection<DriverDTO> getDrivers() {

		Collection<Driver> driverList = this.getDriverRepository().findAll();

		return this.getDtoFactory().createDriversDTO(driverList);
	}

	public DriverDTO getDriverById(long conductorId) {

		Driver driver = this.getDriverRepository().retrieve(conductorId);

		if (driver == null)
			return null;
		return this.getDtoFactory().createDriverDTO(driver);
	}

	public Collection<DriverDTO> getTopTenDrivers() {

		Collection<Driver> driversList = this.getDriverRepository().findTopTen();

		return this.getDtoFactory().createDriversDTO(driversList);
	}
}
