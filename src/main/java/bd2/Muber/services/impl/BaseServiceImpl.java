package bd2.Muber.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import bd2.Muber.dto.DTOFactory;
import bd2.Muber.repositories.DriverRepository;
import bd2.Muber.repositories.PassengerRepository;
import bd2.Muber.repositories.TravelRepository;
import bd2.Muber.services.BaseService;

abstract class BaseServiceImpl implements BaseService {

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private DriverRepository driverRepository;

	@Autowired
	private TravelRepository travelRepository;

	@Autowired
	private DTOFactory dtoFactory;

	public DTOFactory getDtoFactory() {
		return dtoFactory;
	}

	public void setDtoFactory(DTOFactory dtoFactory) {
		this.dtoFactory = dtoFactory;
	}

	public PassengerRepository getPassengerRepository() {
		return passengerRepository;
	}

	public void setPassengerRepository(PassengerRepository passengerRepository) {
		this.passengerRepository = passengerRepository;
	}

	public DriverRepository getDriverRepository() {
		return driverRepository;
	}

	public void setDriverRepository(DriverRepository driverRepository) {
		this.driverRepository = driverRepository;
	}

	public TravelRepository getTravelRepository() {
		return travelRepository;
	}

	public void setTravelRepository(TravelRepository travelRepository) {
		this.travelRepository = travelRepository;
	}

}
