package bd2.Muber.dto.driver;

import java.util.Date;

import bd2.Muber.model.*;

public class DriverDTO {

	private long id;
	private String name;
	private String password;
	private Date date;
	private Date dateLicense;
	private float averangeRating;
	
	public DriverDTO(Driver driver) {
		this.id = driver.getId();
		this.name = driver.getName();
		this.password = driver.getPassword();
		this.date = driver.getDateLogin();
		this.dateLicense = driver.getLicense();
		this.averangeRating = driver.getAverageRating();
	}

	public long getId() {
		return this.id;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDateLicense() {
		return dateLicense;
	}

	public void setDateLicense(Date dateLicense) {
		this.dateLicense = dateLicense;
	}

	public float getAverangeRating() {
		return averangeRating;
	}

	public void setAverangeRating(float averangeRating) {
		this.averangeRating = averangeRating;
	}
	
}
