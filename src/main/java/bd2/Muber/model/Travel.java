package bd2.Muber.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class Travel {

	private long id;
	private boolean opened;
	private String origin;
	private String destination;
	private float cost;
	private Date date;
	private int maximumQuantity;
	private Driver driver;
	private Collection<Passenger> passengers;
	private Collection<Rating> ratings;

	public Travel() {
		this.passengers = new HashSet<Passenger>();
		this.ratings = new HashSet<Rating>();		
	}

	public Travel(Driver driver, String origin, String destination, float cost, Date date, int max) {
		this.origin = origin;
		this.destination = destination;
		this.cost = cost;
		this.date = date;
		this.maximumQuantity = max;
		this.opened = true;
		this.passengers = new HashSet<Passenger>();
		this.ratings = new HashSet<Rating>();
		this.driver = driver;
		driver.addTravel(this);
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

	public String getOrigin() {
		return origin;
	}
	
	public boolean isOpened() {
		return this.opened==true;
	}
	
	public String getDestination() {
		return destination;
	}

	public float getCost() {
		return cost;
	}

	public Date getDate() {
		return date;
	}

	public int getMaximumQuantity() {
		return maximumQuantity;
	}

	public boolean getOpen() {
		return opened;
	}

	public void setOpen(boolean open) {
		this.opened = open;
	}

	private void close() {
		this.opened = false;
	}

	public Driver getDriver() {
		return this.driver;
	}

	public void addPassenger(Passenger p) {
		if (!this.existPassenger(p) && this.isOpened())
			this.passengers.add(p);
	}

	public Collection<Passenger> getPassengers() {
		return this.passengers;
	}

	private void payment() {
		float money = (this.getCost() / (this.getPassengers().size()));
		for (Passenger p : this.getPassengers())
			p.setCredit(p.getCredit() - money);
	}

	public boolean isFull() {
		return (this.getPassengers().size() == this.getMaximumQuantity());
	}

	public Collection<Rating> getRatings() {
		return this.ratings;
	}
	
	private boolean existRatingPassenger(Passenger passenger) {
		if (this.getRatings().size()==0)
			return false;
		for (Rating r : this.getRatings()) {
			if (r.getPassenger().equals(passenger))
				return true;
		}
		return false;
	}

	public boolean canComment(Passenger passenger) {
		if(this.existPassenger(passenger) && !this.existRatingPassenger(passenger) && !this.isOpened())
			return true;
		return false;
	}

	public void addRating(Passenger passenger, Rating rating) {
		if (this.canComment(passenger))
			this.getRatings().add(rating);
	}

	public boolean existPassenger(Passenger passenger) {
		boolean exist = false;
		for (Passenger p : this.getPassengers())
			if (p.equals(passenger)) {
				exist = true;
				break;
			}
		return exist;
	}

	@Override
	public String toString() {
		return (this.getOrigin() + "->" + this.getDestination() + ". " + this.getDate().toString() + ", "
				+ this.getCost());
	}

	public void closeTravelFor(Driver driver) {
		if (this.driver.equals(driver) && this.isOpened()) {
			this.close();
			this.payment();
		}
	}

	public float getAverangeRating() {
		if(this.getRatings().size() == 0){
			return 0;	
		}
		return (this.sumRatingsForTravel() / this.getRatings().size());
	}

	public int sumRatingsForTravel()
	{
		int sum = 0;
		if (this.getRatingsCount()==0)
			return 0;
		for (Rating r : this.getRatings())
			if(!this.isOpened()){
				sum += r.getScore();	
			}
		return sum;		
	}
	
	public int getRatingsCount()
	{
		return this.getRatings().size();
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setMaximumQuantity(int maximumQuantity) {
		this.maximumQuantity = maximumQuantity;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public void setPassengers(Collection<Passenger> passengers) {
		this.passengers = passengers;
	}

	public void setRatings(Collection<Rating> ratings) {
		this.ratings = ratings;
	}


	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(cost);
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + maximumQuantity;
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Travel other = (Travel) obj;
		if (Float.floatToIntBits(cost) != Float.floatToIntBits(other.cost))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (id != other.id)
			return false;
		if (maximumQuantity != other.maximumQuantity)
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		return true;
	}

}
