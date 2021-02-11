package bd2.Muber.dto.travel;

import java.util.Date;

import bd2.Muber.model.*;


public class TravelDTO {

	private long viajeId;
	private long conductorId;
	private String origen;
	private String destino;
	private float costoTotal;
	private Date date;
	private float averangeRating;
	private int cantidadPasajeros;
	private boolean opened;
	
	public TravelDTO() {
		this.viajeId = -1;
		this.conductorId = -1;
		this.origen = "";
		this.destino = "";
		this.costoTotal = -1;
		this.averangeRating = -1;
		this.cantidadPasajeros = -1;
		this.opened = false;
	}	
	
	public TravelDTO(Travel travel) {
		this.viajeId = travel.getId();
		this.conductorId = travel.getDriver().getId();
		this.origen = travel.getOrigin();
		this.destino = travel.getDestination();
		this.costoTotal = travel.getCost();
		this.date = travel.getDate();
		this.averangeRating = travel.getAverangeRating();
		this.cantidadPasajeros = travel.getMaximumQuantity();
		this.opened = travel.isOpened();
	}	
	
	public TravelDTO(long conductorId, String origen, String destino, float costoTotal, int cantidadPasajeros) {
		this.conductorId = conductorId;
		this.origen = origen;
		this.destino = destino;
		this.costoTotal = costoTotal;
		this.cantidadPasajeros = cantidadPasajeros;
		this.opened = true;

	}
	

	
	public long getViajeId() {
		return viajeId;
	}

	public void setViajeId(long viajeId) {
		this.viajeId = viajeId;
	}

	public long getConductorId() {
		return conductorId;
	}
	public void setConductorId(long conductorId) {
		this.conductorId = conductorId;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public float getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(float costoTotal) {
		this.costoTotal = costoTotal;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getAverangeRating() {
		return averangeRating;
	}
	public void setAverangeRating(float averangeRating) {
		this.averangeRating = averangeRating;
	}
	public int getCantidadPasajeros() {
		return cantidadPasajeros;
	}
	public void setCantidadPasajeros(int cantidadPasajeros) {
		this.cantidadPasajeros = cantidadPasajeros;
	}
	public boolean isOpened() {
		return opened;
	}
	public void setOpened(boolean opened) {
		this.opened = opened;
	}
	

	
}