package bd2.Muber.model;

public class Rating {

	public Rating() {
	}

	public Rating(Passenger p, Travel t, String comment, int score) {
		this.comment = comment;
		this.score = score;
		this.passenger = p;
		this.travel = t;
	}

	
	
	
	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}




	private Travel travel;
	private Passenger passenger;

	private String comment;
	private int score;
	private long id;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Passenger getPassenger() {
		return this.passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

}
