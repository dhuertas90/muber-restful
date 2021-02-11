package bd2.Muber.services.impl;

import java.util.Collection;

import bd2.Muber.dto.passenger.PassengerDTO;
import bd2.Muber.model.Passenger;
import bd2.Muber.services.PassengerService;

public class PassengerServiceImpl extends BaseServiceImpl implements PassengerService {

	public Collection<PassengerDTO> getPassengers() {

		Collection<Passenger> passengerList = this.getPassengerRepository().findAll();

		return this.getDtoFactory().createPassengersDTO(passengerList);
	}

	public long savePassenger(PassengerDTO passengerDto) {

		if ((passengerDto.getName() == null || passengerDto.getName().isEmpty()) || 
				(passengerDto.getPassword() == null || passengerDto.getPassword().isEmpty()) ||
				passengerDto.getCredit()<0)
			return 0;
		
		Passenger passenger = this.getDtoFactory().createPassengerFromDTO(passengerDto);

		return this.getPassengerRepository().save(passenger);
	}

	public long updatePassenger(long pasajeroId, float montoPasajero) {
		Passenger passenger = this.getPassengerRepository().retrieve(pasajeroId);

		if (passenger == null || montoPasajero <= 0) {
			return 0;
		}

		passenger.setCredit(passenger.getCredit() + montoPasajero);

		return this.getPassengerRepository().save(passenger);
	}

}
