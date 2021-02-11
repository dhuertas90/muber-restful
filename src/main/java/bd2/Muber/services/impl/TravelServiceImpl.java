package bd2.Muber.services.impl;

import java.util.Collection;

import bd2.Muber.dto.travel.TravelDTO;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Rating;
import bd2.Muber.model.Travel;
import bd2.Muber.services.TravelService;

public class TravelServiceImpl extends BaseServiceImpl implements TravelService {

	public Collection<TravelDTO> getTravelsOpen() {

		Collection<Travel> travelsList = this.getTravelRepository().findAllOpened();

		return this.getDtoFactory().createTravelsDTO(travelsList);
	}

	public long saveTravel(TravelDTO travelDto) {

		Driver driver = this.getDriverRepository().retrieve(travelDto.getConductorId());
		
		if (driver == null || (travelDto.getOrigen() == null || travelDto.getOrigen().isEmpty()) ||
				(travelDto.getDestino() == null || travelDto.getDestino().isEmpty()) ||
				travelDto.getCantidadPasajeros()<=0 || travelDto.getCostoTotal()<0)
			return 0;

		Travel travel = this.getDtoFactory().createTravelFromDTO(travelDto);
		travel.setDriver(driver);

		return this.getTravelRepository().save(travel);
	}

	public long rateTravel(long viajeId, long pasajeroId, int puntaje, String comentario) {
		Travel travel = this.getTravelRepository().retrieve(viajeId);

		Passenger passenger = this.getPassengerRepository().retrieve(pasajeroId);

		if (travel == null || passenger == null || (comentario == null || comentario.isEmpty()) || puntaje<=0)
			return 0;

		Rating rating = new Rating(passenger, travel, comentario, puntaje);

		if (!travel.canComment(passenger))
			return 0;

		travel.addRating(passenger, rating);

		return this.getTravelRepository().save(rating);
	}

	public long updateTravel(long viajeId, long pasajeroId) {
		Travel travel = this.getTravelRepository().retrieve(viajeId);

		Passenger passenger = this.getPassengerRepository().retrieve(pasajeroId);

		if (travel == null || passenger == null)
			return 0;

		if (passenger.getTravels().contains(travel) || !travel.isOpened())
			return 0;

		travel.addPassenger(passenger);

		return this.getTravelRepository().save(travel);
	}

	public long closeTravel(long travelId) {
		Travel travel = this.getTravelRepository().retrieve(travelId);

		if (travel == null || !travel.isOpened()) {
			return 0;
		}
		travel.closeTravelFor(travel.getDriver());

		return this.getTravelRepository().save(travel);
	}

}
