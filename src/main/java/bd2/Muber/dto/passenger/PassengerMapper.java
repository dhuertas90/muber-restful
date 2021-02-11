package bd2.Muber.dto.passenger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import bd2.Muber.model.Passenger;

public class PassengerMapper {

	public static PassengerDTO mapDomainToDto(Passenger domainPassenger) {

		PassengerDTO passengerDTO = new PassengerDTO(domainPassenger);
		return passengerDTO;

	}

	public static Collection<PassengerDTO> mapDomainToDto(Collection<Passenger> passengerList) {

		Collection<PassengerDTO> passengers = new ArrayList<PassengerDTO>();

		for (Passenger p : passengerList) {
			PassengerDTO pas = new PassengerDTO(p);
			passengers.add(pas);
		}
		return passengers;
	}

	public static Passenger mapDtoToDomain(PassengerDTO passengerDTO) {
		Passenger passenger = new Passenger();
		passenger.setCredit(passengerDTO.getCredit());
		passenger.setName(passengerDTO.getName());
		passenger.setPassword(passengerDTO.getPassword());
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		passenger.setDateLogin(date);
		return passenger;
	}

}
