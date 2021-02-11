package bd2.Muber.model;

import java.util.Collection;
import java.util.HashSet;

/**
 * Class Muber.
 * 
 * @author Huertas
 */

public class Muber {

	/**
	 * The users drivers and passengers. Using Set for not exists users
	 * driver/passenger duplicated.
	 */
	private Collection<Driver> drivers;
	private Collection<Passenger> passengers;

	private static Muber myself;
	private long id;

	/**
	 * Instantiates a new Muber.
	 */
	private Muber() {
		this.drivers = new HashSet<Driver>();
		this.passengers = new HashSet<Passenger>();
	}

	public static Muber singleton() {
		if (myself == null)
			myself = new Muber();
		return myself;
	}

	/**
	 * Get and set the id.
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Get and set the users drivers.
	 *
	 * @return the drivers
	 */
	public Collection<Driver> getDrivers() {
		return this.drivers;
	}

	public void setDrivers(Collection<Driver> drivers) {
		this.drivers = drivers;
	}

	/**
	 * Get and set the users passengers.
	 *
	 * @return the passengers
	 */
	public Collection<Passenger> getPassengers() {
		return this.passengers;
	}

	public void setPassengers(Collection<Passenger> passengers) {
		this.passengers = passengers;
	}

	/**
	 * Add Passenger.
	 *
	 * @param Passenger
	 *            the passenger
	 */
	public void addPassenger(Passenger p) {
		this.getPassengers().add(p);
	}

	/**
	 * Add Driver idem passenger
	 */
	public void addDriver(Driver d) {
		this.getDrivers().add(d);
	}

	/**
	 * Get and set the travels. For each Driver get records from method
	 * #getTravels()
	 * 
	 * @return the travels
	 */
	public Collection<Travel> getTravels() {
		Collection<Travel> travels = new HashSet<Travel>();
		for (Driver d : this.getDrivers())
			travels.addAll(d.getTravels());
		return travels;
	}

	/**
	 * Get all travels open.
	 * 
	 * @return the travels
	 */
	public Collection<Travel> getTravelsOpen() {
		Collection<Travel> travelsOpen = new HashSet<Travel>();
		for (Driver d : this.getDrivers())
			travelsOpen.addAll(d.travelsOpen());
		return travelsOpen;
	}

	public String getInfoDriver(Driver driver) {
		String lines = '\n' + "Info Driver" + '\n';
		for (Driver d : this.getDrivers())
			if (d.equals(driver)) {
				lines += d.toString();
				lines += +d.getAverageRating();
				lines += d.printTravels();
				break;
			}
		return lines;
	}

	public void registerOnTravel(Passenger p, Travel t) {
		for (Travel travel : this.getTravelsOpen()) {
			if (travel.equals(t) && !t.isFull() && !t.existPassenger(p)) {
				t.addPassenger(p);
				p.getTravels().add(t);
				p.registerOnTravel(travel);
				break;
			}
		}
	}

	public void closeTravel(Driver d, Travel travel) {
		d.closeTravel(travel);
	}

	public void createRating(Passenger p, Travel travel, String comment, int score) {
		p.createRating(travel, comment, score);
	}

	public static Muber getMyself() {
		return myself;
	}

	public static void setMyself(Muber myself) {
		Muber.myself = myself;
	}

}
