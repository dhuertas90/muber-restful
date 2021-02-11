package bd2.Muber.model;

import java.util.Date;

public class Passenger extends User {
	private float credit;

	public Passenger() {
	}

	public Passenger(String name, String password, Date date, float credit) {
		super(name, password, date);
		this.credit = credit;
	}


	public float getCredit() {
		return this.credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	/*
	 */
	public void registerOnTravel(Travel travel) {

		this.getTravels().add(travel);
		travel.addPassenger(this);

	}

	public void createRating(Travel travel, String comment, int score) {
		Rating rating = new Rating(this, travel, comment, score);
		travel.addRating(this, rating);
	}

}
