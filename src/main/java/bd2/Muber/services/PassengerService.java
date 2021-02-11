package bd2.Muber.services;

import java.util.Collection;

import bd2.Muber.dto.passenger.PassengerDTO;

public interface PassengerService {

	Collection<PassengerDTO> getPassengers();

	long savePassenger(PassengerDTO passengerDto);

	long updatePassenger(long pasajeroId, float montoPasajero);

}
