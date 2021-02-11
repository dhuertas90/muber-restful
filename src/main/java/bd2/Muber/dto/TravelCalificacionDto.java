package bd2.Muber.dto;

public class TravelCalificacionDto {

	
	private long viajeId;
	private long pasajeroId;
	private int puntaje;
	private String comentario;
	
	public TravelCalificacionDto(long viajeId, long pasajeroId, int puntaje, String comentario) {
		this.viajeId = viajeId;
		this.pasajeroId = pasajeroId;
		this.puntaje = puntaje;
		this.comentario = comentario;
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

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	
	
}
