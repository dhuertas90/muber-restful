package bd2.Muber.services;

import java.util.Collection;

import bd2.Muber.dto.travel.TravelDTO;

public interface TravelService {

	Collection<TravelDTO> getTravelsOpen();

	long saveTravel(TravelDTO travelDto);

	long rateTravel(long viajeId, long pasajeroId, int puntaje, String comentario);

	long updateTravel(long viajeId, long pasajeroId);

	long closeTravel(long travelId);

}
