package bd2.Muber.dto;

public class PasajeroCreditoDto {

	private long pasajeroId;
	private float monto;
	
	
	public PasajeroCreditoDto() {
		this.pasajeroId = -1;
		this.monto = -1;
	}	
	
	
	public PasajeroCreditoDto(long pasajeroId, float monto) {
		this.pasajeroId = pasajeroId;
		this.monto = monto;
	}
	
	public long getPasajeroId() {
		return pasajeroId;
	}
	public void setPasajeroId(long pasajeroId) {
		this.pasajeroId = pasajeroId;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	
	
}
