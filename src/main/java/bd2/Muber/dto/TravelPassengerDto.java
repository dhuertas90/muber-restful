package bd2.Muber.dto;

public class TravelPassengerDto {

	private long viajeId;
	private long pasajeroId;
	
	public TravelPassengerDto(long viajeId, long pasajeroId) {
		super();
		this.viajeId = viajeId;
		this.pasajeroId = pasajeroId;
	}

	public long getViajeId() {
		return viajeId;
	}

	public void setViajeId(long viajeId) {
		this.viajeId = viajeId;
	}

	public long getPasajeroId() {
		return pasajeroId;
	}

	public void setPasajeroId(long pasajeroId) {
		this.pasajeroId = pasajeroId;
	}
	
	
	
}
