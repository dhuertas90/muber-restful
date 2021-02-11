package bd2.Muber.dto.travel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import bd2.Muber.model.Travel;

public class TravelMapper {

	public static TravelDTO mapDomainToTravelDto(Travel domainTravel) {
		TravelDTO travelDTO = new TravelDTO(domainTravel);
		return travelDTO;
	}

	public static Collection<TravelDTO> mapDomainToDto(Collection<Travel> travelList) {

		Collection<TravelDTO> travels = new ArrayList<TravelDTO>();

		for (Travel t : travelList) {
			TravelDTO tra = new TravelDTO(t);
			travels.add(tra);
		}
		return travels;
	}

	public static Travel mapDtoToDomain(TravelDTO travelDTO) {

		Travel travel = new Travel();
		travel.setOrigin(travelDTO.getOrigen());
		travel.setDestination(travelDTO.getDestino());
		travel.setCost(travelDTO.getCostoTotal());
		travel.setMaximumQuantity(travelDTO.getCantidadPasajeros());
		travel.setOpen(true);
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		travel.setDate(date);
		return travel;
	}

}