package bd2.Muber.dto.passenger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import bd2.Muber.dto.travel.TravelDTO;
import bd2.Muber.model.*;

public class PassengerDTO {
	
	private long id;
	private String name;
	private String password;
	private Date dateLogin;
	private float credit;
	private Collection<TravelDTO> travels;
	
	
	public PassengerDTO() {
		this.id = -1;
		this.name = "";
		this.password = "";
		this.credit = -1;
		
	}	
		
	public PassengerDTO(Passenger passenger) {
		this.id = passenger.getId();
		this.name = passenger.getName();
		this.password = passenger.getPassword();
		this.dateLogin = passenger.getDateLogin();
		this.credit = passenger.getCredit();
		
		this.travels =  new ArrayList<TravelDTO>();
		for (Travel t : passenger.getTravels()) {
			TravelDTO tra = new TravelDTO(t);
			this.travels.add(tra);
		}		
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateLogin() {
		return dateLogin;
	}

	public void setDateLogin(Date dateLogin) {
		this.dateLogin = dateLogin;
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	public Collection<TravelDTO> getTravels() {
		return travels;
	}

	public void setTravels(Collection<TravelDTO> travels) {
		this.travels = travels;
	}

}
