package bd2.Muber.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import bd2.Muber.services.DriverService;
import bd2.Muber.services.PassengerService;
import bd2.Muber.services.TravelService;

public class ServiceLocator {

	@Autowired
	private PassengerService passengerService;

	@Autowired
	private DriverService driverService;

	@Autowired
	private TravelService travelService;

	private ServiceLocator() {
	}

	public PassengerService getPassengerService() {
		return passengerService;
	}

	public void setPassengerService(PassengerService passengerService) {
		this.passengerService = passengerService;
	}

	public DriverService getDriverService() {
		return driverService;
	}

	public void setDriverService(DriverService driverService) {
		this.driverService = driverService;
	}

	public TravelService getTravelService() {
		return travelService;
	}

	public void setTravelService(TravelService travelService) {
		this.travelService = travelService;
	}

}
