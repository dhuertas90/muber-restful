package bd2.Muber.dto;

import java.util.Collection;

import bd2.Muber.dto.driver.DriverDTO;
import bd2.Muber.dto.driver.DriverMapper;
import bd2.Muber.dto.passenger.PassengerDTO;
import bd2.Muber.dto.passenger.PassengerMapper;
import bd2.Muber.dto.travel.TravelDTO;
import bd2.Muber.dto.travel.TravelMapper;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Travel;

public class DTOFactory {

	public Collection<PassengerDTO> createPassengersDTO(Collection<Passenger> passengerList) {
		return PassengerMapper.mapDomainToDto(passengerList);
	}

	public Collection<DriverDTO> createDriversDTO(Collection<Driver> driverList) {
		return DriverMapper.mapDomainToDto(driverList);
	}

	public DriverDTO createDriverDTO(Driver driver) {
		return DriverMapper.mapDomainToDto(driver);
	}

	public Collection<TravelDTO> createTravelsDTO(Collection<Travel> travelsList) {
		return TravelMapper.mapDomainToDto(travelsList);
	}

	public Travel createTravelFromDTO(TravelDTO travelDTO) {
		return TravelMapper.mapDtoToDomain(travelDTO);
	}

	public Passenger createPassengerFromDTO(PassengerDTO passengerDTO) {
		return PassengerMapper.mapDtoToDomain(passengerDTO);
	}

}
