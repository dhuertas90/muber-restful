package bd2.Muber.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class User {

	protected long id;
	protected String name;
	protected String password;
	protected Date dateLogin;
	protected Collection<Travel> travels;

	public User() {
		this.travels = new HashSet<Travel>();
	}

	public User(String name, String password, Date date) {
		this.name = name;
		this.password = password;
		this.dateLogin = date;
		this.travels = new HashSet<Travel>();
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

	public Collection<Travel> getTravels() {
		return travels;
	}

	public String printTravels() {
		String lines = "Travels" + '\n';
		for (Travel t : this.getTravels())
			lines += '\n' + t.toString();
		return lines;
	}

	@Override
	public String toString() {
		return ('\n' + "Name: " + this.name + '\n' + "Date registred: " + this.dateLogin.toString() + '\n');
	}

	public Date getDateLogin() {
		return dateLogin;
	}

	public void setDateLogin(Date dateLogin) {
		this.dateLogin = dateLogin;
	}

	public void setTravels(Collection<Travel> travels) {
		this.travels = travels;
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
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (dateLogin == null) {
			if (other.dateLogin != null)
				return false;
		} else if (!dateLogin.equals(other.dateLogin))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}


	

}
