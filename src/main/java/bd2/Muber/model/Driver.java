package bd2.Muber.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

public class Driver extends User {

	private Date license;

	public Driver() {
	}

	public Driver(String name, String password, Date date, Date dateLicense) {
		super(name, password, date);
		this.license = dateLicense;
	}

	public void license(Date dateLicense) {
		this.license = dateLicense;
	}

	public Date license() {
		return this.license;
	}

	public boolean licenseEnable() {
		Calendar cal = Calendar.getInstance();
		return (this.license().after(cal.getTime()));
	}

	public void addTravel(Travel travel) {
		this.getTravels().add(travel);
	}

	public Collection<Travel> travelsOpen() {
		Collection<Travel> travelsOpened = new ArrayList<Travel>();
		for (Travel t : this.getTravels()) {
			if (t.isOpened()) {
				travelsOpened.add(t);
			}
		}
		return travelsOpened;
	}
	/* habia creado este metodo para no preguntar por si estaba cerrado, y asi diferenciar directamente.
	* este metodo lo cree cuando estaba resolviendo lo del puntaje,pero no lo use luego. tal vez sirva.
	*/
	/*
	public Collection<Travel> travelsClosed() {
		Collection<Travel> travels = new ArrayList<Travel>();
		for (Travel t : this.getTravels()) {
			if (!t.isOpened())
				travels.add(t);
		}
		return travels;
	}
	*/
	public void newTravel(String origin, String destination, float cost, Date date, int maxPassengers) {
		if (this.licenseEnable()) {
			Travel t = new Travel(this, origin, destination, cost, date, maxPassengers);
			this.addTravel(t);
		}
	}

	public float getAverageRating() {
		float sum = 0;
		int countRatingsPerTravel = 0;
		for (Travel t : this.getTravels()) {
			if (!t.isOpened()){
				sum += t.sumRatingsForTravel();
				countRatingsPerTravel+= t.getRatingsCount();				
			}
		}
		if (sum > 0)
			return (sum / countRatingsPerTravel);
		else
			return 0;
	}


	@Override
	public String toString() {
		return "Driver [getLicense()=" + getLicense() + ", getId()=" + getId() + "]";
	}

	public void closeTravel(Travel travel) {
		travel.closeTravelFor(this);
	}

	public Date getLicense() {
		return license;
	}

	public void setLicense(Date license) {
		this.license = license;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateLogin == null) ? 0 : dateLogin.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Driver other = (Driver) obj;
		if (id != other.getId())
			return false;
		if (license != other.getLicense())
			return false;		
		if (name == null) {
			if (other.getName() != null)
				return false;
		} else if (!name.equals(other.getName()))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.getPassword()))
			return false;
		return true;
	}

	
	

}
